package com.uok.oop.ims.controller;

import com.uok.oop.ims.dto.ItemDto;
import com.uok.oop.ims.model.Item;
import com.uok.oop.ims.service.ItemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/add-item")
    public String addItemsForm(Model model) {
        model.addAttribute("item", new ItemDto());
        model.addAttribute("success", true);
        return "add-item";
    }

    @RequestMapping("/submit-item")
    public String submitItemForm(@ModelAttribute ItemDto item, Model model) {
        try {
            Item newItem = new Item(item.getItemId(), item.getItemName(), item.getDescription(), item.getBuyPrice(), item.getSellPrice(), item.getQuantity(), item.getImageUrl(), item.getSupplier());

            itemService.addNewItems(newItem);

            return "redirect:/item-list";
        } catch (RuntimeException e) {
            model.addAttribute("error", true);
            return "redirect:/add-item?error";
        }
    }

    @GetMapping("/view-item/{id}")
    public String viewItem(@PathVariable(value = "id") String id, Model model) {
        Item itemShow = itemService.getItemById(id);
        model.addAttribute("item", itemShow);
        return "view-item";
    }

    @GetMapping("/item-list")
    public String showItemList(Model model) {
        model.addAttribute("itemList", itemService.getAllItems());
        return "item-list";
    }

    @GetMapping("/showItemForUpdate/{id}")
    public String showItemForUpdate(@PathVariable(value = "id") String id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "/add-item";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable(value = "id") String id) {
        itemService.deleteItemById(id);
        return "redirect:/item-list";
    }
    
    
////    New Code 
//    @GetMapping("/item-list")
//    public String getItemList(Model model) {
//        List<Item> itemList = itemService.getAllItems(); // Replace with actual method to fetch items
//        model.addAttribute("itemList", itemList);
//        return "itemList"; // The HTML page where you want to display the list
//    }
    

    }


