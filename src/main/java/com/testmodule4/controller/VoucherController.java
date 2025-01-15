package com.testmodule4.controller;

import com.testmodule4.model.Voucher;
import com.testmodule4.service.IVoucherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/vouchers")
public class VoucherController {
    @Autowired
    private IVoucherService voucherService;

    @GetMapping
    public String listAllVouchers(Model model) {
        model.addAttribute("vouchers", voucherService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("voucher", new Voucher());
        return "create";
    }

    @PostMapping("/save")
    public String saveVoucher(@Valid @ModelAttribute("voucher") Voucher voucher, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        voucherService.save(voucher);
        return "redirect:/vouchers";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        Optional<Voucher> voucher = voucherService.findById(id);
        if (voucher.isPresent()) {
            model.addAttribute("voucher", voucher.get());
            return "delete";
        } else {
            return "error";
        }
    }

    @PostMapping("/delete")
    public String deleteVoucher(@RequestParam Long id) {
        voucherService.remove(id);
        return "redirect:/vouchers";
    }
}
