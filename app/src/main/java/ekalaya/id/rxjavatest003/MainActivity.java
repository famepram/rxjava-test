package ekalaya.id.rxjavatest003;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    ListView lvResult;
    ArrayAdapter mAdapter;
    ArrayList<String> data = new ArrayList<String>();
    Button btnTap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername  = (EditText) findViewById(R.id.et_username);
        lvResult    = (ListView) findViewById(R.id.lv_result);
        mAdapter = new ResultAdapter(getApplicationContext(),data);
        lvResult.setAdapter(mAdapter);
        swapInt(7,5);

//        Observable<Boolean> emailStream = RxTextView.textChanges(etUsername)
//                .map(v -> v.toString())
//                .filter(v -> v.length() > 3)
//                .debounce(100, TimeUnit.MILLISECONDS)
//                .flatMap(v -> checkIfEmailExistFromAPI(v));

//        btnTap = (Button) findViewById(R.id.btn_tap);
//        Observable<Void> tapStream = RxView.clicks(btnTap).share();

//        Observable<String> emailStream = RxTextView.textChanges(etUsername)
//                .map(v -> v.toString())
//                .filter(s -> s.length() >3)
//                .debounce(1000,TimeUnit.MILLISECONDS);
//
//        emailStream.subscribe(
//                s -> Log.d("RXJAVATEST","S = "+s),
//                error -> Log.d("RXJAVATEST","S ERROR"),
//                () -> Log.d("RXJAVATEST","S ERROR"),
//                onsubscribe -> Log.d("RXJAVATEST","onsubscribe")
//        );


    }

    public Observable<Boolean> checkIfEmailExistFromAPI(final String input){
        Observable<Boolean> test = Observable.just(true);
        return test;
//        return service.getEmails()
//                .flatMap(new Func1<List<String>, Observable<String>>() { // Mengubah stream of List<String> menjadi stream of String
//                    @Override
//                    public Observable<String> call(List<String> strings) {
//                        return Observable.from(strings);
//                    }
//                }).contains(input); // Cek apakah email di emit oleh stream sebelumnya
    }

    private void swapInt(int a, int b){
        Log.d("TAG_TEST", " a ="+a+" b = "+b);
        a = a + b;
        b = a - b;
        a = a - b;
        Log.d("TAG_TEST", " a ="+a+" b = "+b);
    }

}
