package com.candlelabs.inventory.controller.product;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import static com.candlelabs.inventory.RMIInventory.productService;
import static com.candlelabs.inventory.RMIInventory.supplierService;
import static com.candlelabs.inventory.RMIInventory.categoryService;
import static com.candlelabs.inventory.RMIInventory.measurementService;

/**
 *
 * @author Arturo Cordero
 */
public class ProductController extends ProductContainer implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            
            super.initValidators();
            
            super.initTV(productService.listProducts());
            
            super.initCBs(
                    categoryService.listCategories(), 
                    supplierService.listSuppliers(), 
                    measurementService.listMeasurements()
            );
            
        } catch (RemoteException ex) {
            
            System.out.println("Exception: " + ex.toString());
            
        }
        
    }
    
}
