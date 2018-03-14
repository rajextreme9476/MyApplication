package indigo.in.co.daggerApp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import indigo.in.co.daggerApp.ui.model.GetUserModel;
import indigo.in.co.daggerApp.application.DaggerApp;
import indigo.in.co.daggerApp.R;
import indigo.in.co.daggerApp.rest.ApiInterface;
import indigo.in.co.daggerApp.ui.adapter.UserAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;
    private RecyclerView recyclerView;
    private List<GetUserModel.Datum> getResults = new ArrayList<>();
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((DaggerApp) getApplication()).getApiComponent().inject(this);
        init();
        networkCall();

    }
    private void networkCall() {
        Call call = retrofit.create(ApiInterface.class).getUserList();
        call.enqueue(new Callback<GetUserModel>() {
            @Override
            public void onResponse(Call<GetUserModel> call, Response<GetUserModel> response) {
                // Got data. Send it to adapter
                GetUserModel getUserModel = response.body();
                getResults.addAll(getUserModel.getData());
                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GetUserModel> call, Throwable t) {
                t.printStackTrace();
                // TODO: 08/11/16 handle failure
            }
        });

    }

    private void init() {
        recyclerView = findViewById(R.id.rv_users);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        userAdapter = new UserAdapter(this, getResults);
        recyclerView.setAdapter(userAdapter);
    }

}
