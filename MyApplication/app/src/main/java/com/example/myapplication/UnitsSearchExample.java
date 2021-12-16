package com.example.myapplication;

import android.util.Log;

import com.wialon.core.Errors;
import com.wialon.core.Session;
import com.wialon.extra.SearchSpec;
import com.wialon.item.Item;
import com.wialon.remote.handlers.ResponseHandler;
import com.wialon.remote.handlers.SearchResponseHandler;

public class UnitsSearchExample implements Runnable {
    private Session session;

    // Login to server
    private void login() {
        // initialize Wialon session
        session.initSession("http://hst-api.wialon.com");
        // trying login

//        session.createAuthHash(new ResponseHandler() {
//            @Override
//            public void onSuccess(String response) {
//                super.onSuccess(response);
//                Log.d(">>>>>>>createAuthHash", response);
//            }
//
//            @Override
//            public void onFailure(int errorCode, Throwable throwableError) {
//                super.onFailure(errorCode, throwableError);
//                Log.d(">>>>>>>createAuthHash", Errors.getErrorText(errorCode));
//            }
//        });
//        session.login("skbtest", "skb2626882", new ResponseHandler() {
//            @Override
//            public void onSuccess(String response) {
//                super.onSuccess(response);
//                Log.d(">>>>>>>login", String.format("Logged successfully. User name is %s", session.getCurrUser().getName()));
//            }
//
//            @Override
//            public void onFailure(int errorCode, Throwable throwableError) {
//                super.onFailure(errorCode, throwableError);
//                Log.d(">>>>>>>login", Errors.getErrorText(errorCode));
//            }
//        });

        session.loginToken("c8b184d621c1bfc435145713ea8889efC321AD2D0A4ACB4EDCDE0124FD911F95363E293F", new ResponseHandler() {
            @Override
            public void onSuccess(String response) {
                super.onSuccess(response);
                // login succeed
//                System.out.println(String.format("Logged successfully. User name is %s", session.getCurrUser().getName()));
                Log.d(">>>>>>>loginToken", String.format("Logged successfully. User name is %s", session.getCurrUser().getName()));
                //call search units
                searchUnits();
            }

            @Override
            public void onFailure(int errorCode, Throwable throwableError) {
                super.onFailure(errorCode, throwableError);
                // login failed, print error
//                System.out.println(Errors.getErrorText(errorCode));
                Log.d(">>>>>>>loginToken", Errors.getErrorText(errorCode));
            }
        });
    }

    private void searchUnits() {
        //Create new search specification
        SearchSpec searchSpec = new SearchSpec();
        //Set items type to search avl_units
        searchSpec.setItemsType(Item.ItemType.avl_unit);
        //Set property name to search
        searchSpec.setPropName("sys_name");
        //Set property value mask to search all units
        searchSpec.setPropValueMask("*");
        //Set sort type by units name
        searchSpec.setSortType("sys_name");
        //Send search by created search specification with items base data flag and from 0 to maximum number
        session.searchItems(searchSpec, 1, Item.dataFlag.base.getValue(), 0, Integer.MAX_VALUE, new SearchResponseHandler() {
            @Override
            public void onSuccessSearch(Item... items) {
                super.onSuccessSearch(items);
                // Search succeed
//                System.out.println("Search items is successful");
                Log.d(">>>>>>>searchItems", "Search items is successful");
                printUnitsNames(items);
                logout();
            }

            @Override
            public void onFailure(int errorCode, Throwable throwableError) {
                super.onFailure(errorCode, throwableError);
                // search item failed, print error
//                System.out.println(Errors.getErrorText(errorCode));
                Log.d(">>>>>>>searchItems", Errors.getErrorText(errorCode));
                logout();
            }
        });
    }

    private void printUnitsNames(Item... items) {
        if (items != null && items.length > 0) {
//            System.out.println(String.format("%d units found\r\nPrinting their names...", items.length));
            Log.d(">>>>>>>printUnitsNames", String.format("%d units found\r\nPrinting their names...", items.length));
            //Print items names
            for (Item item : items)
//                System.out.println(String.format("\t%s", item.getName()));
                Log.d(">>>>>>>item", String.format("\t%s", item.getName()));
        }
    }

    // Logout
    private void logout() {
        session.logout(new ResponseHandler() {
            @Override
            public void onSuccess(String response) {
                super.onSuccess(response);
                // logout succeed
                System.out.println("Logout successfully");
                Log.d(">>>>>>>logout", "Logout successfully");
                System.exit(0);
            }

            @Override
            public void onFailure(int errorCode, Throwable throwableError) {
                super.onFailure(errorCode, throwableError);
                // logout failed, print error
//                System.out.println(Errors.getErrorText(errorCode));
                Log.d(">>>>>>>logout", Errors.getErrorText(errorCode));
                System.exit(0);
            }
        });
    }

    @Override
    public void run() {
        // get instance of current Session
        session = Session.getInstance();
        login();
    }

//    public static void main(String[] args){
//        new Thread(new UnitsSearchExample()).start();
//    }
}
