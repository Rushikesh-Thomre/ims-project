package com.uok.oop.ims.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.lowagie.text.pdf.AcroFields.Item;
import com.uok.oop.ims.service.ItemService;

@Controller
public class InvoiceController {
//	new 
	  @Autowired
	    private ItemService itemService; 
//	--------------------
//	old
	@GetMapping("/home")
	public String getInnovice() {
		return "redirect:/";
	}
	
//    @GetMapping("/Invoice.html")
//    public String showInvoice(Model model) {
//        // Creating a mock invoice data for simplicity
//        String[] items = {"Item 1", "Item 2", "Item 3"};
//        Invoice invoice = new Invoice();
//
//        // Add the invoice object to the model
//        model.addAttribute("invoice", invoice);
//
//        // Return the Thymeleaf template for the invoice
//        return "Invoice.html"; // The name of the template (invoice.html)
//    }

		
//	new 
    @GetMapping("/Invoice.html")
    public String showInvoiceForm(Model model) {
        List<com.uok.oop.ims.model.Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "Invoice.html"; 
    }
}


