import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.math.*;
import org.gnu.glpk.GLPK;
import org.gnu.glpk.GLPKConstants;
import org.gnu.glpk.GlpkException;
import org.gnu.glpk.SWIGTYPE_p_double;
import org.gnu.glpk.SWIGTYPE_p_int;
import org.gnu.glpk.glp_prob;
import org.gnu.glpk.glp_smcp;

public class main {
	
	static void randomizer(float[] w) {
		for(int i = 0; i< 37; i++ ) {
			float rand = -1000000 + new Random().nextInt(2000001);
			w[i] = rand;
		}
		
	}
    
	static void makelp(int[][] iArrays) {
        int count = 0;
        glp_prob lp;
        glp_smcp parm;
        SWIGTYPE_p_int ind;
        SWIGTYPE_p_double val;
        int ret;
        float[] weight = new float[37];
        
        for(int x = 1; x <1001; x++) {
        try {
            // Create problem
            lp = GLPK.glp_create_prob();
            System.out.println("Problem created: " + x);
            GLPK.glp_set_prob_name(lp, "weighted mountain: "+ x);

            // Define columns
            GLPK.glp_add_cols(lp, 36);
            
            randomizer(weight);
            for(int i = 1; i <37 ; i++) {
            	String name = "x" + (i);
            	GLPK.glp_set_col_name(lp, i, name); 
            	GLPK.glp_set_col_kind(lp, i, GLPKConstants.GLP_IV);
                GLPK.glp_set_col_bnds(lp, i, GLPKConstants.GLP_LO, 0, 0);
                GLPK.glp_set_obj_coef(lp, i, weight[i]);
            }
            
            GLPK.glp_set_col_bnds(lp, 1, GLPKConstants.GLP_FX, 0, 0);
            GLPK.glp_set_col_bnds(lp, 2, GLPKConstants.GLP_FX, 6, 6);
            GLPK.glp_set_col_bnds(lp, 3, GLPKConstants.GLP_FX, 4, 4);
            GLPK.glp_set_col_bnds(lp, 4, GLPKConstants.GLP_FX, 12, 12);
            GLPK.glp_set_col_bnds(lp, 6, GLPKConstants.GLP_FX, 7, 7);
            GLPK.glp_set_col_bnds(lp, 7, GLPKConstants.GLP_FX, 16, 16);
            GLPK.glp_set_col_bnds(lp, 10, GLPKConstants.GLP_FX, 9, 9);
            GLPK.glp_set_col_bnds(lp, 11, GLPKConstants.GLP_FX, 19, 19);
            GLPK.glp_set_col_bnds(lp, 15, GLPKConstants.GLP_FX, 11, 11);
            GLPK.glp_set_col_bnds(lp, 16, GLPKConstants.GLP_FX, 22, 22);
            GLPK.glp_set_col_bnds(lp, 21, GLPKConstants.GLP_FX, 13, 13);
            GLPK.glp_set_col_bnds(lp, 22, GLPKConstants.GLP_FX, 25, 25);
            GLPK.glp_set_col_bnds(lp, 28, GLPKConstants.GLP_FX, 14, 14);
            GLPK.glp_set_col_bnds(lp, 29, GLPKConstants.GLP_FX, 28, 28);
            GLPK.glp_set_col_bnds(lp, 30, GLPKConstants.GLP_FX, 28, 28);
            GLPK.glp_set_col_bnds(lp, 31, GLPKConstants.GLP_FX, 27, 27);
            GLPK.glp_set_col_bnds(lp, 32, GLPKConstants.GLP_FX, 26, 26);
            GLPK.glp_set_col_bnds(lp, 33, GLPKConstants.GLP_FX, 25, 25);
            GLPK.glp_set_col_bnds(lp, 34, GLPKConstants.GLP_FX, 23, 23);
            GLPK.glp_set_col_bnds(lp, 35, GLPKConstants.GLP_FX, 20, 20);
            GLPK.glp_set_col_bnds(lp, 36, GLPKConstants.GLP_FX, 15, 15);
            
           

            // Create constraints

            // Allocate memory
            ind = GLPK.new_intArray(4);
            val = GLPK.new_doubleArray(4);

            // Create rows
            GLPK.glp_add_rows(lp, 63);

            // Set row details
            GLPK.glp_set_row_name(lp, 1, "c1");
            GLPK.glp_set_row_bnds(lp, 1, GLPKConstants.GLP_UP, 0, 10);
            GLPK.intArray_setitem(ind, 1, 5);
            GLPK.intArray_setitem(ind, 2, 1);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.glp_set_mat_row(lp, 1, 2, ind, val);

            GLPK.glp_set_row_name(lp, 2, "c2");
            GLPK.glp_set_row_bnds(lp, 2, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 4);
            GLPK.intArray_setitem(ind, 2, 3);
            GLPK.intArray_setitem(ind, 3, 2);
            GLPK.intArray_setitem(ind, 4, 5);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 2, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 3, "c3");
            GLPK.glp_set_row_bnds(lp, 3, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 6);
            GLPK.intArray_setitem(ind, 2, 2);
            GLPK.intArray_setitem(ind, 3, 3);
            GLPK.intArray_setitem(ind, 4, 5);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 3, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 4, "c4");
            GLPK.glp_set_row_bnds(lp, 4, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 8);
            GLPK.intArray_setitem(ind, 2, 2);
            GLPK.intArray_setitem(ind, 3, 4);
            GLPK.intArray_setitem(ind, 4, 5);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 4, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 5, "c5");
            GLPK.glp_set_row_bnds(lp, 5, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 5);
            GLPK.intArray_setitem(ind, 2, 7);
            GLPK.intArray_setitem(ind, 3, 4);
            GLPK.intArray_setitem(ind, 4, 8);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 5, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 6, "c6");
            GLPK.glp_set_row_bnds(lp, 6, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 4);
            GLPK.intArray_setitem(ind, 2, 9);
            GLPK.intArray_setitem(ind, 3, 5);
            GLPK.intArray_setitem(ind, 4, 8);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 6, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 7, "c7");
            GLPK.glp_set_row_bnds(lp, 7, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 9);
            GLPK.intArray_setitem(ind, 2, 3);
            GLPK.intArray_setitem(ind, 3, 5);
            GLPK.intArray_setitem(ind, 4, 6);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 7, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 8, "c8");
            GLPK.glp_set_row_bnds(lp, 8, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 8);
            GLPK.intArray_setitem(ind, 2, 6);
            GLPK.intArray_setitem(ind, 3, 5);
            GLPK.intArray_setitem(ind, 4, 9);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 8, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 9, "c9");
            GLPK.glp_set_row_bnds(lp, 9, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 5);
            GLPK.intArray_setitem(ind, 2, 10);
            GLPK.intArray_setitem(ind, 3, 6);
            GLPK.intArray_setitem(ind, 4, 9);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 9, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 10, "c10");
            GLPK.glp_set_row_bnds(lp, 10, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 12);
            GLPK.intArray_setitem(ind, 2, 4);
            GLPK.intArray_setitem(ind, 3, 7);
            GLPK.intArray_setitem(ind, 4, 8);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 10, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 11, "c11");
            GLPK.glp_set_row_bnds(lp, 11, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 11);
            GLPK.intArray_setitem(ind, 2, 8);
            GLPK.intArray_setitem(ind, 3, 7);
            GLPK.intArray_setitem(ind, 4, 12);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 11, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 12, "c12");
            GLPK.glp_set_row_bnds(lp, 12, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 7);
            GLPK.intArray_setitem(ind, 2, 13);
            GLPK.intArray_setitem(ind, 3, 8);
            GLPK.intArray_setitem(ind, 4, 12);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 12, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 13, "c13");
            GLPK.glp_set_row_bnds(lp, 13, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 13);
            GLPK.intArray_setitem(ind, 2, 5);
            GLPK.intArray_setitem(ind, 3, 8);
            GLPK.intArray_setitem(ind, 4, 9);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 13, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 14, "c14");
            GLPK.glp_set_row_bnds(lp, 14, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 12);
            GLPK.intArray_setitem(ind, 2, 9);
            GLPK.intArray_setitem(ind, 3, 8);
            GLPK.intArray_setitem(ind, 4, 13);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 14, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 15, "c15");
            GLPK.glp_set_row_bnds(lp, 15, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 14);
            GLPK.intArray_setitem(ind, 2, 8);
            GLPK.intArray_setitem(ind, 3, 9);
            GLPK.intArray_setitem(ind, 4, 13);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 15, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 16, "c16");
            GLPK.glp_set_row_bnds(lp, 16, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 14);
            GLPK.intArray_setitem(ind, 2, 6);
            GLPK.intArray_setitem(ind, 3, 9);
            GLPK.intArray_setitem(ind, 4, 10);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 16, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 17, "c17");
            GLPK.glp_set_row_bnds(lp, 17, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 13);
            GLPK.intArray_setitem(ind, 2, 10);
            GLPK.intArray_setitem(ind, 3, 9);
            GLPK.intArray_setitem(ind, 4, 14);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 17, 4, ind, val);


            GLPK.glp_set_row_name(lp, 18, "c18");
            GLPK.glp_set_row_bnds(lp, 16, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 9);
            GLPK.intArray_setitem(ind, 2, 15);
            GLPK.intArray_setitem(ind, 3, 10);
            GLPK.intArray_setitem(ind, 4, 14);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 18, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 19, "c19");
            GLPK.glp_set_row_bnds(lp, 19, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 17);
            GLPK.intArray_setitem(ind, 2, 7);
            GLPK.intArray_setitem(ind, 3, 11);
            GLPK.intArray_setitem(ind, 4, 12);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 19, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 20, "c20");
            GLPK.glp_set_row_bnds(lp, 20, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 16);
            GLPK.intArray_setitem(ind, 2, 12);
            GLPK.intArray_setitem(ind, 3, 11);
            GLPK.intArray_setitem(ind, 4, 17);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 20, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 21, "c21");
            GLPK.glp_set_row_bnds(lp, 21, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 11);
            GLPK.intArray_setitem(ind, 2, 18);
            GLPK.intArray_setitem(ind, 3, 12);
            GLPK.intArray_setitem(ind, 4, 17);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 21, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 22, "c22");
            GLPK.glp_set_row_bnds(lp, 22, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 18);
            GLPK.intArray_setitem(ind, 2, 8);
            GLPK.intArray_setitem(ind, 3, 12);
            GLPK.intArray_setitem(ind, 4, 13);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 22, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 23, "c23");
            GLPK.glp_set_row_bnds(lp, 23, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 17);
            GLPK.intArray_setitem(ind, 2, 13);
            GLPK.intArray_setitem(ind, 3, 12);
            GLPK.intArray_setitem(ind, 4, 18);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 23, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 24, "c24");
            GLPK.glp_set_row_bnds(lp, 24, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 12);
            GLPK.intArray_setitem(ind, 2, 19);
            GLPK.intArray_setitem(ind, 3, 13);
            GLPK.intArray_setitem(ind, 4, 18);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 24, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 25, "c25");
            GLPK.glp_set_row_bnds(lp, 25, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 19);
            GLPK.intArray_setitem(ind, 2, 9);
            GLPK.intArray_setitem(ind, 3, 13);
            GLPK.intArray_setitem(ind, 4, 14);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 25, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 26, "c26");
            GLPK.glp_set_row_bnds(lp, 26, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 18);
            GLPK.intArray_setitem(ind, 2, 14);
            GLPK.intArray_setitem(ind, 3, 13);
            GLPK.intArray_setitem(ind, 4, 19);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 26, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 27, "c27");
            GLPK.glp_set_row_bnds(lp, 27, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 13);
            GLPK.intArray_setitem(ind, 2, 20);
            GLPK.intArray_setitem(ind, 3, 14);
            GLPK.intArray_setitem(ind, 4, 19);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 27, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 28, "c28");
            GLPK.glp_set_row_bnds(lp, 28, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 20);
            GLPK.intArray_setitem(ind, 2, 10);
            GLPK.intArray_setitem(ind, 3, 14);
            GLPK.intArray_setitem(ind, 4, 15);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 28, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 29, "c29");
            GLPK.glp_set_row_bnds(lp, 29, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 19);
            GLPK.intArray_setitem(ind, 2, 15);
            GLPK.intArray_setitem(ind, 3, 14);
            GLPK.intArray_setitem(ind, 4, 20);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 29, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 30, "c30");
            GLPK.glp_set_row_bnds(lp, 30, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 14);
            GLPK.intArray_setitem(ind, 2, 21);
            GLPK.intArray_setitem(ind, 3, 15);
            GLPK.intArray_setitem(ind, 4, 20);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 30, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 31, "c31");
            GLPK.glp_set_row_bnds(lp, 31, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 23);
            GLPK.intArray_setitem(ind, 2, 11);
            GLPK.intArray_setitem(ind, 3, 16);
            GLPK.intArray_setitem(ind, 4, 17);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 31, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 32, "c32");
            GLPK.glp_set_row_bnds(lp, 32, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 22);
            GLPK.intArray_setitem(ind, 2, 17);
            GLPK.intArray_setitem(ind, 3, 16);
            GLPK.intArray_setitem(ind, 4, 23);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 32, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 33, "c33");
            GLPK.glp_set_row_bnds(lp, 33, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 16);
            GLPK.intArray_setitem(ind, 2, 24);
            GLPK.intArray_setitem(ind, 3, 17);
            GLPK.intArray_setitem(ind, 4, 23);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 33, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 34, "c34");
            GLPK.glp_set_row_bnds(lp, 34, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 24);
            GLPK.intArray_setitem(ind, 2, 12);
            GLPK.intArray_setitem(ind, 3, 17);
            GLPK.intArray_setitem(ind, 4, 18);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 34, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 35, "c35");
            GLPK.glp_set_row_bnds(lp, 35, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 23);
            GLPK.intArray_setitem(ind, 2, 18);
            GLPK.intArray_setitem(ind, 3, 17);
            GLPK.intArray_setitem(ind, 4, 24);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 35, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 36, "c36");
            GLPK.glp_set_row_bnds(lp, 36, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 17);
            GLPK.intArray_setitem(ind, 2, 25);
            GLPK.intArray_setitem(ind, 3, 18);
            GLPK.intArray_setitem(ind, 4, 24);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 36, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 37, "c37");
            GLPK.glp_set_row_bnds(lp, 37, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 25);
            GLPK.intArray_setitem(ind, 2, 13);
            GLPK.intArray_setitem(ind, 3, 18);
            GLPK.intArray_setitem(ind, 4, 19);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 37, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 38, "c38");
            GLPK.glp_set_row_bnds(lp, 38, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 24);
            GLPK.intArray_setitem(ind, 2, 19);
            GLPK.intArray_setitem(ind, 3, 18);
            GLPK.intArray_setitem(ind, 4, 25);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 38, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 39, "c39");
            GLPK.glp_set_row_bnds(lp, 39, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 18);
            GLPK.intArray_setitem(ind, 2, 26);
            GLPK.intArray_setitem(ind, 3, 19);
            GLPK.intArray_setitem(ind, 4, 25);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 39, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 40, "c40");
            GLPK.glp_set_row_bnds(lp, 40, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 26);
            GLPK.intArray_setitem(ind, 2, 14);
            GLPK.intArray_setitem(ind, 3, 19);
            GLPK.intArray_setitem(ind, 4, 20);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 40, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 41, "c41");
            GLPK.glp_set_row_bnds(lp, 41, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 25);
            GLPK.intArray_setitem(ind, 2, 20);
            GLPK.intArray_setitem(ind, 3, 19);
            GLPK.intArray_setitem(ind, 4, 26);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 41, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 42, "c42");
            GLPK.glp_set_row_bnds(lp, 42, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 19);
            GLPK.intArray_setitem(ind, 2, 27);
            GLPK.intArray_setitem(ind, 3, 20);
            GLPK.intArray_setitem(ind, 4, 26);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 42, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 43, "c43");
            GLPK.glp_set_row_bnds(lp, 43, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 27);
            GLPK.intArray_setitem(ind, 2, 15);
            GLPK.intArray_setitem(ind, 3, 20);
            GLPK.intArray_setitem(ind, 4, 21);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 43, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 44, "c44");
            GLPK.glp_set_row_bnds(lp, 44, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 20);
            GLPK.intArray_setitem(ind, 2, 28);
            GLPK.intArray_setitem(ind, 3, 21);
            GLPK.intArray_setitem(ind, 4, 27);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 44, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 45, "c45");
            GLPK.glp_set_row_bnds(lp, 45, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 26);
            GLPK.intArray_setitem(ind, 2, 21);
            GLPK.intArray_setitem(ind, 3, 20);
            GLPK.intArray_setitem(ind, 4, 27);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 45, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 46, "c46");
            GLPK.glp_set_row_bnds(lp, 46, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 30);
            GLPK.intArray_setitem(ind, 2, 16);
            GLPK.intArray_setitem(ind, 3, 22);
            GLPK.intArray_setitem(ind, 4, 23);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 46, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 47, "c47");
            GLPK.glp_set_row_bnds(lp, 47, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 29);
            GLPK.intArray_setitem(ind, 2, 23);
            GLPK.intArray_setitem(ind, 3, 22);
            GLPK.intArray_setitem(ind, 4, 30);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 47, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 48, "c48");
            GLPK.glp_set_row_bnds(lp, 48, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 31);
            GLPK.intArray_setitem(ind, 2, 22);
            GLPK.intArray_setitem(ind, 3, 23);
            GLPK.intArray_setitem(ind, 4, 30);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 48, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 49, "c49");
            GLPK.glp_set_row_bnds(lp, 49, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 31);
            GLPK.intArray_setitem(ind, 2, 17);
            GLPK.intArray_setitem(ind, 3, 23);
            GLPK.intArray_setitem(ind, 4, 24);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 49, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 50, "c50");
            GLPK.glp_set_row_bnds(lp, 50, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 30);
            GLPK.intArray_setitem(ind, 2, 24);
            GLPK.intArray_setitem(ind, 3, 23);
            GLPK.intArray_setitem(ind, 4, 31);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 50, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 51, "c51");
            GLPK.glp_set_row_bnds(lp, 51, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 23);
            GLPK.intArray_setitem(ind, 2, 32);
            GLPK.intArray_setitem(ind, 3, 24);
            GLPK.intArray_setitem(ind, 4, 31);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 51, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 52, "c52");
            GLPK.glp_set_row_bnds(lp, 52, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 32);
            GLPK.intArray_setitem(ind, 2, 18);
            GLPK.intArray_setitem(ind, 3, 24);
            GLPK.intArray_setitem(ind, 4, 25);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 52, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 53, "c53");
            GLPK.glp_set_row_bnds(lp, 53, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 31);
            GLPK.intArray_setitem(ind, 2, 25);
            GLPK.intArray_setitem(ind, 3, 24);
            GLPK.intArray_setitem(ind, 4, 32);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 53, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 54, "c54");
            GLPK.glp_set_row_bnds(lp, 54, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 24);
            GLPK.intArray_setitem(ind, 2, 33);
            GLPK.intArray_setitem(ind, 3, 25);
            GLPK.intArray_setitem(ind, 4, 32);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 54, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 55, "c55");
            GLPK.glp_set_row_bnds(lp, 55, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 33);
            GLPK.intArray_setitem(ind, 2, 19);
            GLPK.intArray_setitem(ind, 3, 25);
            GLPK.intArray_setitem(ind, 4, 26);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 55, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 56, "c56");
            GLPK.glp_set_row_bnds(lp, 56, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 32);
            GLPK.intArray_setitem(ind, 2, 26);
            GLPK.intArray_setitem(ind, 3, 25);
            GLPK.intArray_setitem(ind, 4, 33);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 56, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 57, "c57");
            GLPK.glp_set_row_bnds(lp, 57, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 25);
            GLPK.intArray_setitem(ind, 2, 34);
            GLPK.intArray_setitem(ind, 3, 26);
            GLPK.intArray_setitem(ind, 4, 33);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 57, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 58, "c58");
            GLPK.glp_set_row_bnds(lp, 58, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 34);
            GLPK.intArray_setitem(ind, 2, 20);
            GLPK.intArray_setitem(ind, 3, 26);
            GLPK.intArray_setitem(ind, 4, 27);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 58, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 59, "c59");
            GLPK.glp_set_row_bnds(lp, 59, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 33);
            GLPK.intArray_setitem(ind, 2, 27);
            GLPK.intArray_setitem(ind, 3, 26);
            GLPK.intArray_setitem(ind, 4, 34);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 59, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 60, "c60");
            GLPK.glp_set_row_bnds(lp, 60, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 26);
            GLPK.intArray_setitem(ind, 2, 35);
            GLPK.intArray_setitem(ind, 3, 27);
            GLPK.intArray_setitem(ind, 4, 34);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 60, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 61, "c61");
            GLPK.glp_set_row_bnds(lp, 61, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 35);
            GLPK.intArray_setitem(ind, 2, 21);
            GLPK.intArray_setitem(ind, 3, 27);
            GLPK.intArray_setitem(ind, 4, 28);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 61, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 62, "c62");
            GLPK.glp_set_row_bnds(lp, 62, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 34);
            GLPK.intArray_setitem(ind, 2, 28);
            GLPK.intArray_setitem(ind, 3, 27);
            GLPK.intArray_setitem(ind, 4, 35);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 62, 4, ind, val);
            
            GLPK.glp_set_row_name(lp, 63, "c63");
            GLPK.glp_set_row_bnds(lp, 63, GLPKConstants.GLP_UP, 0, 0);
            GLPK.intArray_setitem(ind, 1, 36);
            GLPK.intArray_setitem(ind, 2, 27);
            GLPK.intArray_setitem(ind, 3, 28);
            GLPK.intArray_setitem(ind, 4, 35);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, -1.);
            GLPK.doubleArray_setitem(val, 4, -1.);
            GLPK.glp_set_mat_row(lp, 63, 4, ind, val);            
            
            
            // Free memory
            GLPK.delete_intArray(ind);
            GLPK.delete_doubleArray(val);

            // Define objective
            GLPK.glp_set_obj_name(lp, "Obj");
            GLPK.glp_set_obj_dir(lp, GLPKConstants.GLP_MAX);

            // Write model to file
             GLPK.glp_write_lp(lp, null, x + "mountain.lp");

            // Solve model
            parm = new glp_smcp();
            GLPK.glp_init_smcp(parm);
            ret = GLPK.glp_simplex(lp, parm);

            // Retrieve solution
            if (ret == 0) {
                count = writelp(lp, iArrays, count);
            } else {
                System.out.println("The problem could not be solved");
            }

            // Free memory
            GLPK.glp_delete_prob(lp);
        } catch (GlpkException ex) {
            ex.printStackTrace();
        }
        } // for loop ends
    }

    static int writelp(glp_prob lp, int[][] iArrays, int count) {
        int i;
        int n;
        String name;
        double val;
        boolean equal;
        boolean unique = true;

        name = GLPK.glp_get_obj_name(lp);
        val = GLPK.glp_get_obj_val(lp);
        System.out.print(name);
        System.out.print(" = ");
        System.out.println(val);
        n = GLPK.glp_get_num_cols(lp);
        int[] temp = new int[36];
        for (i = 1; i <= n; i++) {
            name = GLPK.glp_get_col_name(lp, i);
            val = GLPK.glp_get_col_prim(lp, i);
            temp[i-1] = (int) val;
            System.out.print(name);
            System.out.print(" = ");
            System.out.println(val);
        }
        
    	 
        
        if(count == 0) {
        	for(int y = 0; y <36 ; y++) {   //first so must be unique
        		iArrays[count][y] = temp[y];
        		
        	}      	       	
        	count++;
        	
        	
        	
        }else {        	
        	for(int x = 0; x < count; x++) {       		
        		
        		equal = Arrays.equals(iArrays[x], temp);
        		if(equal == true) {
        			unique = false ;
        		}     		        		        		
        	}
         	
        }
        if(unique != false) {
        	
        		for(int y = 0; y <36 ; y++) {   
            		iArrays[count][y] = temp[y];
            	}      	       	
            	count++;
           	
        }
        unique = false; 
        equal = true;
        
    	return count;      
        
        
    }

    public static void main(String[] args) {
		int[][] iArrays = new int[10][36];
		makelp(iArrays);
		
		System.out.println();
		for(int x = 1; x < 10; x++) {
			System.out.print(x + ": ");
			for(int i = 0; i < 36; i++) {
				System.out.print(iArrays[x][i] + " ");
			}
			System.out.println();
		}

	}

}
