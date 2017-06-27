package com.example.administrator.myrxjava;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Observable<String> sendMsg = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hi,RxJava");
            }
        });

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"lilin",18));
        students.add(new Student(2,"Been",20));
        students.add(new Student(3,"David",25));

//        Observable.from(students)
//                .flatMap(new Func1<Student, Observable<Integer>>(){
//                    @Override
//                    public Observable<Integer> call(Student student) {
//                        Log.i("AAA", "call:"+Thread.currentThread().getId()+" "+Thread.currentThread().getName());
//                        return Observable.just(student.age);
//                    }
//                })
//                .subscribeOn(Schedulers.newThread())//发送数据在子线程中
//                .subscribeOn(AndroidSchedulers.mainThread())//发送数据在子线程中(无效 只读取第一次subscribeOn方法线程)
//                .observeOn(AndroidSchedulers.mainThread())//发送数据在子线程中
//                .filter(new Func1<Integer, Boolean>() {
//                    @Override
//                    public Boolean call(Integer integer) {
//                        return integer>19;
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())//之后的操作在主线程执行
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {Toast.makeText(MainActivity.this, integer+"", Toast.LENGTH_SHORT).show();}
//                });


        count = 10;
        CountDownTimer countDownTimer = new CountDownTimer(10200, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("AAA", "onTick: "+millisUntilFinished +" "+ --count);
            }

            @Override
            public void onFinish() {
                Log.i("AAA", "onFinish: "+ --count);
            }
        };
        countDownTimer.start();


//        Observable<String> justObservable = Observable.just("just1", "just2").repeat(3);//依次发送"just1"和"just2"
//        justObservable.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.i("AAA", "call: "+s);
//            }
//        });

//        Observable<String> hahaha = Observable.just("hahaha", "this is RxJava");

//        final ArrayList<String> strList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            strList.add(""+i+i+i+i+i);
//        }
//        Observable.create(new Observable.OnSubscribe<ArrayList<String>>(){
//            @Override
//            public void call(Subscriber<? super ArrayList<String>> subscriber) {
//                subscriber.onNext(strList);
//            }
//        })
//        .map(new Func1<ArrayList<String>, String>() {
//            @Override
//            public String call(ArrayList<String> strings) {
//                for (int i = 0; i < strings.size(); i++) {
//                    if (strings.get(i).equals("33333")){
//                        return strings.get(i);
//                    }
//                }
//
//                return null;
//            }
//        })
//        .subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.i("AAA", "call: "+s);
//            }
//        });


//        Observable defer = Observable.defer(new Func0<Observable<String>>() {
//            @Override
//            public Observable<String> call() {
//                return Observable.just("即时创建");
//            }
//        });

//        Observable<Long> interval = Observable.interval(1000, TimeUnit.MILLISECONDS);
//        interval.subscribe(new Action1<Long>() {
//            @Override
//            public void call(Long aLong) {
//                Toast.makeText(MainActivity.this, ""+aLong, Toast.LENGTH_SHORT).show();
//            }
//        });


//        Observer receiver = new Observer<String>() {
//            @Override
//            public void onCompleted() {
//                //数据接收完成时调用
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                //发生错误调用
//            }
//
//            @Override
//            public void onNext(String s) {
//                //正常接收数据调用
//                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
//            }
//        };

//        interval.subscribe(receiver);

//        from.subscribe(new Action1<String>(){
//            @Override
//            public void call(String s) {
//                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
//            }
//        });


    }



















}
