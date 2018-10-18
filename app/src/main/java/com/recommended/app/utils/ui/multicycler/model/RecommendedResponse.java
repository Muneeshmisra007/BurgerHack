package com.recommended.app.utils.ui.multicycler.model;

import com.burgerhack.multicycler.model.RowBehaviour;
import java.util.ArrayList;

public class RecommendedResponse {


    public Response recommendedresponse;

    public class Response {

        int errorCode;

        int errorStatus;

        public void setCategories(ArrayList<RecommendedCategory> categories) {
            this.categories = categories;
        }


        ArrayList<RecommendedCategory> categories;

        public int getErrorCode() {
            return errorCode;
        }

        public int getErrorStatus() {
            return errorStatus;
        }

        public ArrayList<RecommendedCategory>  getCategories() {
            return categories;
        }

        public ArrayList<RowBehaviour> getCategoriesRows() {
            ArrayList<RowBehaviour> rows = new ArrayList<>();
            for (RecommendedCategory category : categories) {
                rows.add(category);
            }
            return rows;
        }
    }

    public Response getResponse() {
        return recommendedresponse;
    }

}
