/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Product;
import model.ProductDAO;
import model.Purchase;
import model.PurchaseDAO;
import model.PurchaseDetail;
import model.PurchaseDetailDAO;
import model.ShoppingCart;

/**
 *
 * @author university
 */
@WebServlet(name = "controller_shoppingCart", urlPatterns = {"/controller_shoppingCart"})
public class controller_shoppingCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Product product = new Product();
    ProductDAO productDao = new ProductDAO();
    List<ShoppingCart> cartList = new ArrayList();
    int itemProduct = 0;
    double total = 0.0;
    int quantity = 1;
    
    Purchase purchase = new Purchase();
    PurchaseDAO purchaseDao = new PurchaseDAO();
    PurchaseDetailDAO purchaseDetailDao = new PurchaseDetailDAO();
    List<PurchaseDetail> purchaseDetail = new ArrayList();
    int idConsumer = 0;
    double totalCash;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action"); 
        
        switch(action){
            case "addShoppingCart":
                int indexProduct = 0;
                quantity = 1;
                
                int idProduct = Integer.parseInt(request.getParameter("id"));
                product = productDao.getProductById(idProduct);
                
                if(!cartList.isEmpty()){
                    for(int i = 0; i < cartList.size(); i++){
                        if(idProduct == cartList.get(i).getIdProduct()){
                            indexProduct = i;
                        }
                    }
                    if(idProduct == cartList.get(indexProduct).getIdProduct()){
                        quantity += cartList.get(indexProduct).getQuantity();
                        double subtotal = quantity * cartList.get(indexProduct).getPrice();
                        cartList.get(indexProduct).setQuantity(quantity);
                        cartList.get(indexProduct).setSubtotal(subtotal);
                    }else{
                        itemProduct++;
                
                        ShoppingCart cart = new ShoppingCart();
                        cart.setItem(itemProduct);
                        cart.setIdProduct(product.getIdProduct());
                        cart.setImage(product.getImage());
                        cart.setDescription(product.getDescription());
                        cart.setPrice(product.getPrice());
                        cart.setQuantity(quantity);
                        cart.setSubtotal(quantity * product.getPrice());

                        cartList.add(cart);
                    }
                }else{
                    itemProduct++;
                
                    ShoppingCart cart = new ShoppingCart();
                    cart.setItem(itemProduct);
                    cart.setIdProduct(product.getIdProduct());
                    cart.setImage(product.getImage());
                    cart.setDescription(product.getDescription());
                    cart.setPrice(product.getPrice());
                    cart.setQuantity(quantity);
                    cart.setSubtotal(quantity * product.getPrice());

                    cartList.add(cart);
                }
                
                request.setAttribute("counter", cartList.size());
                request.getRequestDispatcher("controller_product?action=allproducts").forward(request, response);
                break;
                
            case "delete":
                int productId = Integer.parseInt(request.getParameter("id"));
                for(int i = 0; i < cartList.size(); i++){
                    if (cartList.get(i).getIdProduct()== productId){
                        cartList.remove(i);
                    }
                }
                request.getRequestDispatcher("controller_shoppingCart?action=shoppingCart").forward(request, response);
                break;
                
            case "deleteAll":
                cartList.removeAll(cartList);
                request.getRequestDispatcher("controller_shoppingCart?action=shoppingCart").forward(request, response);
                break;
            case "shoppingCart":
                total = 0.0;
                if(!cartList.isEmpty()){
                    request.setAttribute("cartProducts", cartList);
                    for(int i = 0; i < cartList.size(); i++){
                        total += cartList.get(i).getSubtotal();
                    }
                    request.setAttribute("total", total);
                    request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
                }else{
                    request.setAttribute("total", total);
                    request.setAttribute("cartProducts", null);
                    request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
                }
                totalCash = total;
                break;
            case "buyNow":
                idConsumer = Integer.parseInt(request.getParameter("idConsumer"));
                request.setAttribute("total", totalCash);
                request.getRequestDispatcher("metodopago.jsp").forward(request, response);
                break;
            case "purchase":
                int payment = Integer.parseInt(request.getParameter("payment"));
                Date date = new Date();
                
                purchase.setIdSeller(1);
                purchase.setIdConsumer(idConsumer);
                purchase.setPaymentType(payment);
                purchase.setDate(date);
                purchase.setTotalAmount(totalCash);
                purchase.setPaymentStatus("Canceled");
                
                purchaseDao.insertPurchase(purchase);
                int purchaseId = purchaseDao.getIdPurchase();
                for(int i = 0; i < cartList.size(); i++){
                    PurchaseDetail pd = new PurchaseDetail();
                    
                    pd.setIdPurchase(purchaseId);
                    pd.setIdProduct(cartList.get(i).getIdProduct());
                    pd.setAmount(cartList.get(i).getQuantity());
                    pd.setSubtotal(cartList.get(i).getSubtotal());
                    
                    purchaseDetail.add(pd);
                }
                purchaseDetailDao.insertPurchaseDetail( purchaseDetail);
                cartList.removeAll(cartList);
                
                request.getRequestDispatcher("controller_product?action=allproducts").forward(request, response);
                break;
            default:
                request.setAttribute("counter", cartList.size());
                request.getRequestDispatcher("controller_product?action=allproducts").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
