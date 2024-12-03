package com.uok.oop.ims.controller;

import com.uok.oop.ims.repository.ItemRepository;
import com.uok.oop.ims.service.ClientService;
import com.uok.oop.ims.service.ItemService;
import com.uok.oop.ims.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String home(Model model) {
        long totalItems = itemService.getTotalItems();
        long totalSuppliers = supplierService.getTotalSuppliers();
        long totalCustomers = clientService.getTotalCustomers();

        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalSuppliers", totalSuppliers);
        model.addAttribute("totalCustomers", totalCustomers);
        model.addAttribute("totalQuantity", itemService.getTotalQuantityOfAllItems());
        model.addAttribute("totalExpenditure", itemService.getTotalExpenditureForAllItems());
        model.addAttribute("totalRevenue", itemService.getTotalRevenue());
        model.addAttribute("totalProjectedIncome", itemService.getProjectedIncome());

        return "home";
    }

    @GetMapping("/report")
    public String report(Model model){
        model.addAttribute("itemList", itemService.getAllItems());
        model.addAttribute("supplierList", supplierService.getAllSuppliers());
        model.addAttribute("customerList", clientService.getAllClients());

        return "report";
    }
    
    
//    dfgdfg  
    
//    @GetMapping("/")
//    public String index(Model model) {
//        // Fetch data from the repository (e.g., total quantity of all items)
//        Integer totalQuantity = ItemRepository.sumTotalQuantity();
//
//        // Add the data to the model (this can be accessed in the Thymeleaf template)
//        model.addAttribute("totalQuantity", totalQuantity);
//
//        // Return the name of the Thymeleaf template (index.html)
//        return "index";
//    }
    
}
