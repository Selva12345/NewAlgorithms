package com.wayfair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CouponCategory {
    public static void main(String[] args) {
        CouponCategory couponCategory=new CouponCategory();
        String [][]coupons = {
        { "Comforter Sets", "Comforters Sale", "2020-01-01","10%"},
        { "Comforter Sets", "Cozy Comforter Coupon", "2021-01-01","15$"},
        { "Bedding", "Best Bedding Bargains","2019-01-01","35%"},
        { "Bedding", "Savings on Bedding","2019-01-01","25%"},
        { "Bed & Bath", "Low price for Bed & Bath", "2018-01-01","50%" },
        { "Bed & Bath", "Bed & Bath extravaganza", "2019-01-01","75%" },
      /*  { "Bed & Bath", "Big Savings for Bed & Bath","2030-01-01","10%" }*/};
       String[][] categories = {
        {"Comforter Sets", "Bedding"},
        {"Bedding", "Bed & Bath"},
        {"Bed & Bath", "None"},
        {"Soap Dispensers", "Bathroom Accessories"},
        {"Bathroom Accessories", "Bed & Bath"},
        {"Toy Organizers", "Baby And Kids"},
        {"Baby And Kids", "None"}};
       String products [][]={{"Cozy Comforter Sets","100.00", "Comforter Sets"},
            {"All-in-one Bedding Set", "50.00", "Bedding"},
            {"Infinite Soap Dispenser", "500.00" ,"Bathroom Accessories"},
            {"Rainbow Toy Box","257.00", "Baby And Kids"}
       };
        try {
            couponCategory.initialize(coupons,categories,products);
           /* System.out.println(couponCategory.findCoupon("Bed & Bath").couponName);
            System.out.println(couponCategory.findCoupon("Bedding").couponName);
            System.out.println(couponCategory.findCoupon("Bathroom Accessories").couponName);
            System.out.println(couponCategory.findCoupon("Comforter Sets").couponName);*/
            System.out.println(couponCategory.productCoupon("Cozy Comforter Sets"));
            System.out.println(couponCategory.productCoupon("All-in-one Bedding Set"));
            System.out.println(couponCategory.productCoupon("Infinite Soap Dispenser"));
            System.out.println(couponCategory.productCoupon("Rainbow Toy Box"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    Map<String,String> couponParentCategory;
    Map<String, List<Coupon>> couponsCategory;
    Map<String, Product> productCategory=new HashMap<>();
    void initialize(String [][]coupons , String[][] categories, String[][] products) throws ParseException {
        couponParentCategory=new HashMap<>();
        for(int i=0;i<categories.length;i++){
            String arr[] =categories[i];
            couponParentCategory.put(arr[0],arr[1]);

        }
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
        couponsCategory= new HashMap<>();
        for(int i=0;i<coupons.length;i++){
            String temp[]=coupons[i];
           List<Coupon> couponList= couponsCategory.getOrDefault(temp[0],new ArrayList<>());

           Date date=formatter.parse(temp[2]);
           Coupon coupon=new Coupon(temp[1],date,temp[3]);
           couponList.add(coupon);
            couponsCategory.put(temp[0],couponList);
        }
        for(int i=0;i<products.length;i++){
            String arr[]=products[i];
            productCategory.put(arr[0],new Product(arr[0],Double.parseDouble(arr[1]),arr[2]));

        }
       // System.out.println(couponsCategory);
        //System.out.println(couponParentCategory);
        for (String cat:couponParentCategory.keySet()){
            Coupon coupon=findCoupon(cat);
            List<Coupon> list=couponsCategory.getOrDefault(cat,new ArrayList<>());
            list.add(coupon);
        }
    }
    public String productCoupon(String product){
        if(!productCategory.containsKey(product)){
                return null;
        }
        Product productValue=productCategory.get(product);
        Coupon coupon= findCoupon(productValue.category);
        if(coupon!=null&&coupon.discount.endsWith("%")){
            Double percent=Double.parseDouble(coupon.discount.substring(0,coupon.discount.length()-1));
            double v = productValue.price * (percent) / 100;
            return String.format("%.2f",productValue.price-v);
        }else if(coupon!=null){
            Double val=Double.parseDouble(coupon.discount.substring(0,coupon.discount.length()-1));
            return String.format("%.2f",productValue.price-val);
        }else{
            return String.format("%.2f",productValue.price);
        }

    }
    public Coupon findCoupon(String category){
        List<Coupon> couponList=couponsCategory.get(category);

        Coupon coupon =getLatestCoupon(couponList);
        if(coupon!=null){
               return  coupon;
        }else{
            Coupon couponNew=null;
            String newcategory=null;

            while (couponNew==null&&category!=null){
                newcategory= couponParentCategory.get(category);
                List<Coupon> couponListNew=couponsCategory.get(newcategory);
                couponNew =getLatestCoupon(couponListNew);
                category=newcategory;
            }

            return couponNew;
        }
    }

    private Coupon getLatestCoupon(List<Coupon> couponList) {

        Date newDate=new Date();
        Coupon result = null;
        if(couponList==null)return result;
        for(Coupon coupon:couponList){

                if(coupon.dateModified.before(newDate)&&result!=null&&coupon.dateModified.after(result.dateModified)){
                        result=coupon;
                }else if (coupon.dateModified.before(newDate)&&result==null){
                    result=coupon;
                }
           // System.out.println("date"+result.dateModified);
        }
        return result;
    }
class Product{
        String productName;
        Double price;
        String category;
        Product(String productName,Double price, String category){
            this.productName=productName;
            this.price=price;
            this.category=category;
        }
}
    class Coupon{
        String couponName;
        Date dateModified;

        String discount;

        public Coupon(String couponName,  Date dateModified, String discount) {
            this.couponName = couponName;
            this.dateModified = dateModified;
            this.discount=discount;
        }
    }

}
