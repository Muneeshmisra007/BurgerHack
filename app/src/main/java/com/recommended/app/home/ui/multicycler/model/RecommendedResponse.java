package com.recommended.app.home.ui.multicycler.model;

import com.burgerhack.multicycler.model.RowBehaviour;
import java.util.ArrayList;

public class RecommendedResponse {


    public Response recommendedresponse;

    public class Response {

        int errorCode;

        int errorStatus;

        public void setCategories(ArrayList<RecommendedCategories> categories) {
            this.categories = categories;
        }


        ArrayList<RecommendedCategories> categories;

        public int getErrorCode() {
            return errorCode;
        }

        public int getErrorStatus() {
            return errorStatus;
        }

        public ArrayList<RecommendedCategories>  getCategories() {
            return categories;
        }

        public ArrayList<RowBehaviour> getCategoriesRows() {
            ArrayList<RowBehaviour> rows = new ArrayList<>();
            for (RecommendedCategories category : categories) {
                rows.add(category);
            }
            return rows;
        }
    }

    public Response getResponse() {
        return recommendedresponse;
    }

}
