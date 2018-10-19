package com.example.administrator.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.administrator.kotlin.domain.RequestForecastCommod
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    /*    var i: Int = 7
        var a: Double = i.toDouble()
        val s = "study"
        val c = s[1]
        val f1 = Forecast(Date(),22.0f,"热")
        val f2 = f1.copy(temprature = 27.4f)
        val (date,temprature,detail) = f1*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        textView.text = "hello kotlin1"
//        val recyclerView: RecyclerView = find(R.id.rv)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = ForecastListadapter(items)
/*        for (c in s) {
            print(s)
        }*/
        async {
            //            Request("http://samples.openweathermap.org/data/2.5/weather?id=2172797&appid=b6907d289e10d714a6e88b30761fae22").run()
            val result = RequestForecastCommod("94043").excute()
            uiThread {
                /*             recyclerView.adapter = ForecastListadapter(result,
                                     object : ForecastListadapter.OnItemClickListener {
                                         override fun invoke(forecast: Forecast) {
                                             toast(forecast.iconUrl)
                                         }
                                     }
                             )*/

//                recyclerView.adapter = ForecastListadapter(result) { forecast -> toast(forecast.iconUrl) }
                //后面的函数只接受一个参数可以使用it代替左边的参数
//                recyclerView.adapter = ForecastListadapter(result) { toast(it.iconUrl) }
            }
        }
        /*====================================RxJava创建操作符start===============================================*/

        /*      //create是rxjava当中最基本的创建Observable的方式
              Observable.create<Int> { emitter ->
                  emitter.onNext(1)
                  emitter.onNext(2)
                  emitter.onNext(3)
                  emitter.onComplete()
              }
                      //subscribe是观察者订阅被观察者的方法，他有很多的重构方法
                      .subscribe(object : Observer<Int> {
                          //定义局部变量Disposable,用于中断事件
                          var mDisposable: Disposable? = null

                          override fun onSubscribe(d: Disposable) {
                              mDisposable = d
                          }

                          override fun onNext(t: Int) {
                              if (t == 2) {
                                  mDisposable?.dispose()
                              }
                              Log.d(TAG, t.toString() + "被调用")
                          }

                          override fun onComplete() {
                              Log.d(TAG, "onComplete()被调用")
                          }

                          override fun onError(e: Throwable) {
                          }
                      })*/

        //just接收一个数组对象，会依次打印结果,最多只支持10个长度的数组
//        Observable.just(1,2,3,4,5,6,7,8,9,0).subscribe { t -> Log.d(TAG, "接收到的结果:" + t) }


        val items = arrayOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1)
        //*也指将数组传递给参数
        //fromArray遍历数组
        /*  Observable.fromArray(*items)
                  .subscribe(object : Observer<Int> {
                      override fun onNext(t: Int) {
                          Log.d(TAG,"接收到的结果:"+t)
                      }

                      override fun onSubscribe(d: Disposable) {

                      }

                      override fun onError(e: Throwable) {

                      }

                      override fun onComplete() {

                      }
                  })*/

/*        //创建list集合
        var list: ArrayList<Int>? = ArrayList()
        list?.add(1)
        list?.add(2)
        list?.add(3)
        //fromIterable遍历集合
        Observable.fromIterable(list)
                .subscribe(object : Observer<Int> {
                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onNext(t: Int) {
                        Log.d(TAG, "集合遍历得到结果:" + t)
                    }

                    override fun onSubscribe(d: Disposable) {
                    }
                })*/

        /*       //timer延迟发送
               Observable.timer(2, TimeUnit.SECONDS)
                       .subscribe(object : Observer<Long> {
                           override fun onNext(t: Long) {
                               Log.d(TAG, "延迟2s得到结果")
                           }

                           override fun onSubscribe(d: Disposable) {
                           }


                           override fun onComplete() {
                           }

                           override fun onError(e: Throwable) {
                           }
                       })*/

/*        //interval每间隔指定时间发送事件
        //第一个参数:第一次延迟时间
        //第二个参数:后面每次延迟时间
        Observable.interval(3, 1, TimeUnit.SECONDS)
                .subscribe(object : Observer<Long> {
                    override fun onNext(t: Long) {
                        Log.d(TAG, "每隔一段时间发送执行一次")
                    }

                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onError(e: Throwable) {
                    }
                })*/

        //range指定事件从哪个开始到哪个结束
/*        Observable.range(3, 10)
                .subscribe(object : Observer<Int> {
                    override fun onNext(t: Int) {
                        Log.d(TAG, t.toString())
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable) {
                    }

                })*/

        /*====================================RxJava创建操作符end===============================================*/


        /*====================================RxJava变换操作符start===============================================*/
        //map 将被观察者发送的每一个事件通过指定函数处理，返回另外一个事件
/*        Observable.create<Int> { emitter ->
            emitter.onNext(1)
            emitter.onNext(2)
            emitter.onNext(3)
        }.map { t -> "通过map操作符将int类型转换成string类型" + t }.subscribe({ t ->
            Log.d(TAG, t)
        })*/


        //flatMap将最初的事件拆分成或单独转换，再合并成一个新的事件,拆分出来的事件顺序不一定还是原来事件的顺序
/*        Observable.create<Int> { emitter ->
            emitter.onNext(1)
            emitter.onNext(2)
            emitter.onNext(3)
        }.flatMap(object : Function<Int, ObservableSource<String>> {
            override fun apply(t: Int): ObservableSource<String> {
                var list: ArrayList<String>? = ArrayList()
                for (i in 1..3) {
                    list?.add("我是事件"+t+"拆分出来的事件"+i)
                }

                return Observable.fromIterable(list)
            }

        }).subscribe(object:Consumer<String>{
            override fun accept(t: String?) {
                Log.d(TAG,t)
            }
        })
    }*/

        //concatMap拆分的事件与最开始事件的顺序一样
/*        Observable.create<Int> { emitter ->
            emitter.onNext(1)
            emitter.onNext(2)
            emitter.onNext(3)
        }.concatMap(object : Function<Int, ObservableSource<String>> {
            override fun apply(t: Int): ObservableSource<String> {
                var list: ArrayList<String>? = ArrayList()
                for (i in 1..3) {
                    list?.add("我是事件"+t+"拆分出来的事件"+i)
                }

                return Observable.fromIterable(list)
            }

        }).subscribe(object:Consumer<String>{
            override fun accept(t: String?) {
                Log.d(TAG,t)
            }
        })*/

        /*====================================RxJava变换操作符end===============================================*/



        /*====================================RxJava合并操作符start===============================================*/
        Observable.concat(Observable.just(1,2,3),
                Observable.just(2,3,5),Observable.just(6,7,8),
                Observable.just(9,0,1))
                .subscribe(object:Observer<Int>{
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                    }

                    override fun onNext(t: Int) {
                        Log.d(TAG,"合并之后的事件结果:"+t)
                    }

                    override fun onError(e: Throwable) {
                    }

                })

        /*====================================RxJava合并操作符end===============================================*/

    }



}
