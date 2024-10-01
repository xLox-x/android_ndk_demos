package ndk.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import ndk.demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'demo' library on application startup.
    static {
        System.loadLibrary("demo");
    }

    RecyclerView mRecyclerView;
    MyAdapter mMyAdapter ;
    private ActivityMainBinding binding;
    private List<JNIAction> mJNICaseList = new ArrayList<>();

    class JNIAction {
        String mTitle;
        Supplier<String> mAction;

        public JNIAction(String title, Supplier<String> action) {
            mTitle = title;
            mAction = action;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mRecyclerView = binding.recyclerview;
        mMyAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);

        mJNICaseList.add(new JNIAction("stringFromJNI", this::stringFromJNI));
        mJNICaseList.add(new JNIAction("helloJNI", this::helloJNI));
        mJNICaseList.add(new JNIAction("helloCPP", this::helloCPP));
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHoder> {

        @NonNull
        @Override
        public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null, true);
            RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            itemView.setLayoutParams(lp);

            MyViewHoder myViewHoder = new MyViewHoder(itemView);
            myViewHoder.mTitleTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = myViewHoder.getAdapterPosition();
                    JNIAction action = mJNICaseList.get(position);
                    String result = action.mAction.get();
                    Toast.makeText(view.getContext(), result, Toast.LENGTH_SHORT).show();
                }
            });
            return myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
            String title = mJNICaseList.get(position).mTitle;
            holder.mTitleTv.setText(String.format("%s: %s", position + 1, title));
        }

        @Override
        public int getItemCount() {
            return mJNICaseList.size();
        }
    }

    class MyViewHoder extends RecyclerView.ViewHolder {
        TextView mTitleTv;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            mTitleTv = itemView.findViewById(R.id.textView);
        }
    }

    /**
     * A native method that is implemented by the 'demo' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    private String helloJNI() {
        HelloJNI hello = new HelloJNI();
        hello.sayHello();
        return "Hello Java use C";
    }

    private String helloCPP() {
        HelloCPP hello = new HelloCPP();
        hello.sayHelloCPP();
        return "Hello Java use C++";
    }

    private String helloMixture() {
        HelloMixture hello = new HelloMixture();
        hello.sayHelloMixture();
        return "Hello Java use Mixture";
    }

    private String testJNIPrimitive() {
        double average = new TestJNIPrimitive().average(2, 3);
        return "Average: " + average;
    }

    private String testJNIString() {
        return new TestJNIString().sayHello("Hello from Java");
    }

    private String testJNIPrimitiveArray() {
        int[] numbers = {22, 33, 33};
        double[] results = new TestJNIPrimitiveArray().sumAndAverage(numbers);
        return String.format("In Java, the sum is %s, the average is %s", results[0], results[1]);
    }

    private String testJNIInstanceVariable() {
        TestJNIInstanceVariable obj = new TestJNIInstanceVariable();
        obj.modifyInstanceVariable();
        return obj.toString();
    }
    private String testJNIStaticVariable() {
        TestJNIStaticVariable obj = new TestJNIStaticVariable();
        obj.modifyStaticVariable();
        return obj.toString();
    }

    private String testJNICallback() {
        TestJNICallBackMethod obj = new TestJNICallBackMethod();
        obj.nativeMethod();
        return "callback test";
    }

    private String testSuperMethod() {
        Baby obj = new Baby(7, "james");
        obj.say();
        obj.superMethod();
        return "Super method test";
    }

    private String testConstructor() {
        TestJNIConstructor obj = new TestJNIConstructor();
        return "In Java, the number is :" + obj.getIntegerObject(9999);
    }

    private String testJNIObjectArray() {
        Integer[] numbers = {11, 22, 33};
        TestJNIObjectArray objectArray = new TestJNIObjectArray();
        Double[] results = objectArray.sumAndAverage(numbers);
        return String.format("In Java, the sum is %s, the average is %s", results[0], results[1]);
    }

    private String testJNIReference() {
        TestJNIReference reference = new TestJNIReference();

        int result1 = reference.getIntegerObject(1);
        int result2 = reference.anotherGetIntegerObject(11);
        return String.format("In Java, result1 is %s, result2 is %s", result1, result2);
    }
}