package practicalexercises;

import java.util.Arrays;
import practicalexercises.models.Clothing;
import practicalexercises.models.Shoe;
import practicalexercises.models.Hat;
import practicalexercises.models.Pant;
import practicalexercises.models.Tshirt;


public class Main {

    public static void main(String[] args) {
        
        Clothing clothing = new Clothing();
        //                        (   Shoe   )(   Pant  )(T-shirt)(Hat)
        //                          1   2   3   1   2   3   1   2   1
        CharSequence[] creating = {"S","S","S","P","P","P","T","T","H"};
        Clothing[] clothingVector = new Clothing[creating.length];
        //             S P T H
        int[] index = {1,1,1,1};
        String[] names = {"Shoe","Pants","Tshirt","Hat"};
        for(int i=0; i<creating.length;i++){
            String type;
            if(creating[i] == "S"){
                type = names[0]+index[0];
                Shoe shoe = new Shoe("code"+type,type,index[0],"brand"+type,"size"+type,"color"+type,"material"+type,"closureType"+type);
                clothingVector[i] = shoe;
                index[0] ++;
            } else if(creating[i] == "P"){
                type = names[1]+index[1];
                Pant pant = new Pant("style"+type, "typeFabric"+type, "code"+type, type, index[1], "brand"+type, "size"+type, "color"+type);
                clothingVector[i] = pant;
                index[1] ++;
            } else if(creating[i] == "T"){
                type = names[2]+index[2];
                Tshirt tshirt = new Tshirt("sleeve"+type, "neck"+type,"code"+ type, type, index[2], "brand"+type, "size"+type, "color"+type);
                clothingVector[i] = tshirt;
                index[2] ++;
            } else {
                type = names[3]+index[3];
                Hat hat = new Hat("hatType"+type, "code"+type, type, index[3], "brand"+type, "size"+type, "color"+type);
                clothingVector[i] = hat;
                index[2] ++;
            }
        
        }
        
       for (Clothing item : clothingVector) {
           item.displayBrand();
        }
        
    }
}
