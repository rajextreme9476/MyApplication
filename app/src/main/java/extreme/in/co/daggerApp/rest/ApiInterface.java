package extreme.in.co.daggerApp.rest;


import extreme.in.co.daggerApp.ui.model.GetUserModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    /*@GET("connect/users/{userId}")
    Call<GetRequestResponseModel> getRequest(@Path("userId") String userId);
*/
    @GET("api/users?page=2")
    Call<GetUserModel> getUserList();

}



