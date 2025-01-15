package com.testmodule4.controller;

import com.testmodule4.model.Voucher;
import com.testmodule4.service.IVoucherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
            return "error_voucher";
        }
    }

    @PostMapping("/delete")
    public String deleteVoucher(@RequestParam Long id) {
        voucherService.remove(id);
        return "redirect:/vouchers";
    }

    @GetMapping("/search")
    public String searchVouchersByDiscount(@RequestParam("search") String discount, Model model) {
        long amount = Long.parseLong(discount);
        model.addAttribute("vouchers", voucherService.findAllByDiscount(amount));
        return "list";
    }

    @GetMapping("/search_start_date")
    public String searchVouchersByStartDate(@RequestParam("search") String date, Model model) {
        LocalDate startDate = LocalDate.parse(date);
        model.addAttribute("vouchers", voucherService.findAllByStartTime(startDate));
        return "list";
    }

    @GetMapping("/search_end_date")
    public String searchVouchersByEndDate(@RequestParam("search") String date, Model model) {
        LocalDate startDate = LocalDate.parse(date);
        model.addAttribute("vouchers", voucherService.findAllByEndTime(startDate));
        return "list";
    }

    @GetMapping("/search_all")
    public String searchVouchersBy3Fields(@RequestParam long discount, @RequestParam LocalDate start_date, @RequestParam LocalDate end_date, Model model) {

//        ArrayList<Voucher> vouchers = new ArrayList<>();
//        vouchers.addAll(voucherService.findAllByDiscount(discount));
//        vouchers.addAll(voucherService.findAllByStartTime(start_date));
//        vouchers.addAll(voucherService.findAllByEndTime(end_date));

        Iterable<Voucher> vouchers = voucherService.findAllByThreeFields(discount, start_date, end_date);

        model.addAttribute("vouchers", vouchers);
        return "list";
    }
}
