package com.example.administrator.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function

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
        /* async {
             //            Request("http://samples.openweathermap.org/data/2.5/weather?id=2172797&appid=b6907d289e10d714a6e88b30761fae22").run()
             val result = RequestForecastCommod("94043").excute()
             uiThread {
                 *//*             recyclerView.adapter = ForecastListadapter(result,
                                     object : ForecastListadapter.OnItemClickListener {
                                         override fun invoke(forecast: Forecast) {
                                             toast(forecast.iconUrl)
                                         }
                                     }
                             )*//*

//                recyclerView.adapter = ForecastListadapter(result) { forecast -> toast(forecast.iconUrl) }
                //后面的函数只接受一个参数可以使用it代替左边的参数
//                recyclerView.adapter = ForecastListadapter(result) { toast(it.iconUrl) }
            }
        }*/
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

        //concat将多个事件合并成一个事件 串行执行，被订阅者只能小于等于4
        //concatArray将多个事件合并成一个事件 串行执行，被订阅者只能可以大于4
        /*      Observable.concat(Observable.just(1,2,3),
                      Observable.just(2,3,5)
                      ,Observable.just(6,7,8),
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

                      })*/

        //merge/mergeArray功能与concat/concatArray差不多，但是他是按照时间线执行的，并不是事件的串行执行
/*        Observable.merge(Observable.intervalRange(0,3,1,1,TimeUnit.SECONDS)
        ,Observable.intervalRange(2,3,1,1,TimeUnit.SECONDS))
                .subscribe(object:Observer<Long>{
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                    }

                    override fun onNext(t: Long) {
                        Log.d(TAG,"组合之后的事件结果:"+t)
                    }

                    override fun onError(e: Throwable) {
                    }

                })*/

/*        Observable.concat(Observable.create(object:ObservableOnSubscribe<Int>{
            override fun subscribe(emitter: ObservableEmitter<Int>) {
                emitter.onNext(1)
                emitter.onNext(2)
                emitter.onNext(3)
                emitter.onError(NullPointerException()) //执行onError，不使用concatArrayDelayError第二个事件不执行
                emitter.onComplete()
            }

        }),Observable.just(4,5,6))
                .subscribe(object:Observer<Int>{
                    override fun onComplete() {
                        Log.d(TAG,"执行onComplete()")
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: Int) {
                        Log.d(TAG,"接收到的结果:"+t)
                    }

                })*/

        //
        /* Observable.concatArrayDelayError(Observable.create(object: ObservableOnSubscribe<Int> {
             override fun subscribe(emitter: ObservableEmitter<Int>) {
                 emitter.onNext(1)
                 emitter.onNext(2)
                 emitter.onNext(3)
                 emitter.onError(NullPointerException()) //onError，将在第二个事件执行完之后再执行
                 emitter.onComplete()
             }

         }), Observable.just(4,5,6))
                 .subscribe(object: Observer<Int> {
                     override fun onComplete() {
                         Log.d(TAG,"执行onComplete()")
                     }

                     override fun onError(e: Throwable) {
                         Log.d(TAG,"执行Error事件")
                     }

                     override fun onSubscribe(d: Disposable) {
                     }

                     override fun onNext(t: Int) {
                         Log.d(TAG,"接收到的结果:"+t)
                     }

                 })*/

/*        val observable1 = Observable.create(object : ObservableOnSubscribe<Int> {
            override fun subscribe(emitter: ObservableEmitter<Int>) {
                Log.d(TAG, "被观察事件1发送事件1")
                emitter.onNext(1)
                Thread.sleep(1000)
                Log.d(TAG, "被观察事件1发送事件2")
                emitter.onNext(2)
                Thread.sleep(1000)
                Log.d(TAG, "被观察事件1发送事件3")
                emitter.onNext(3)
                Thread.sleep(1000)
            }

        })

        val observable2 = Observable.create(object : ObservableOnSubscribe<String> {
            override fun subscribe(emitter: ObservableEmitter<String>) {
                Log.d(TAG, "被观察事件2发送事件a")
                emitter.onNext("a")
                Thread.sleep(1000)
                Log.d(TAG, "被观察事件2发送事件b")
                emitter.onNext("b")
                Thread.sleep(1000)

            }

        })


        //合并多个被观察者，合并之后的事件数量为传入的多个事件源中事件最少的数量,多余的事件虽然不会合并到最终的事件源中，但是任然会发送
        Observable.zip(observable1, observable2, object : BiFunction<Int, String, String> {
            override fun apply(t1: Int, t2: String): String {
                return t1.toString() + t2
            }

        }).subscribe(object : Observer<String> {
            override fun onNext(t: String) {
                Log.d(TAG, "合并之后的事件" + t)
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }

        })*/


        //combineLatest与zip的合并类似，只是zip的合并是一对一的，而combineLatest是按时间合并的
        //会将先发送完的数据的最后一个与后面的数据进行合并
/*        Observable.combineLatest(Observable.just(1L, 2L, 3L),
                Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS),
        object : BiFunction<Long, Long, Long> {
            override fun apply(t1: Long, t2: Long): Long {
                return t1!! + t2!!
            }

        }).subscribe { s -> Log.e(TAG, "合并的结果是： " + s!!) }*/


        //reduce将被观察者事件合并成一个事件发送
/*        Observable.just(1, 2, 3, 4)
                .reduce(object : BiFunction<Int, Int, Int> {
                    override fun apply(t1: Int, t2: Int): Int {
                        Log.d(TAG, "计算"+t1+"*"+t2)
                        return t1 * t2
                    }

                }).subscribe(object:Consumer<Int>{
            override fun accept(t: Int?) {
                Log.d(TAG,"最终计算结果"+t)
            }

        })*/


        /*====================================RxJava组合/合并操作符end===============================================*/


        /*====================================RxJava功能操作符start===============================================*/
        //subscribe事件订阅

        //线程调度：
        //     1、SubscribeOn()指定被观察者的线程，如果存在多个只有第一个有效
        //     2、ObserverOn()指定观察者所在线程，

/*        Observable.create(object:ObservableOnSubscribe<String>{
            override fun subscribe(emitter: ObservableEmitter<String>) {
                Log.d(TAG,"被观察者的工作线程"+Thread.currentThread().name)
                emitter.onNext("a")
                emitter.onComplete()
            }

        }).subscribeOn(Schedulers.io())//被观察者运行的线程
                .subscribeOn(AndroidSchedulers.mainThread())//有多个指定被观察者线程，会无效
                .observeOn(AndroidSchedulers.mainThread()) //观察者工作线程
                .subscribe(object:Observer<String>{
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG,"观察者的工作线程"+Thread.currentThread().name)
            }

            override fun onError(e: Throwable) {
                Log.d(TAG,"处理Error事件")
            }

            override fun onNext(t: String) {
                Log.d(TAG,"接收到"+t)
            }

            override fun onComplete() {
                Log.d(TAG,"处理Complete事件")
            }

        })*/

/*        Observable.create(object : ObservableOnSubscribe<Int> {
            override fun subscribe(emitter: ObservableEmitter<Int>) {
                emitter.onNext(1)
                emitter.onNext(2)
                emitter.onNext(3)
                emitter.onError(Throwable("发生错误"))
            }

        })
                //每次发送事件的时候我会调用一次
                .doOnEach(object : Consumer<Notification<Int>> {
                    override fun accept(t: Notification<Int>?) {
                        Log.d(TAG, "doOnEach" + t.toString())
                    }

                })
                //执行onNext之前调用
                .doOnNext(object : Consumer<Int> {
                    override fun accept(t: Int?) {
                        Log.d(TAG, "doOnNext" + t.toString())
                    }

                })
                //OnNext执行完之后调用
                .doAfterNext(object : Consumer<Int> {
                    override fun accept(t: Int?) {
                        Log.d(TAG, "doAfterNext" + t.toString())
                    }

                })

                //OnComplete正常事件发送完之后调用
                .doOnComplete(object : Action {
                    override fun run() {
                        Log.d(TAG, "doOnComplete")
                    }

                })
                //发送Error事件时调用
                .doOnError(object : Consumer<Throwable> {
                    override fun accept(t: Throwable?) {
                        Log.d(TAG, "doOnError" + t?.message)
                    }

                })
                //事件发送完之后，无论发送完成还是错误都会执行
                .doOnTerminate(object : Action {
                    override fun run() {
                        Log.d(TAG, "doOnTerminate")
                    }

                })
                //最后执行
                .doFinally(object : Action {
                    override fun run() {
                        Log.d(TAG, "doFinally")
                    }

                }).subscribe(object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onComplete() {
                Log.d(TAG,"处理Complete事件")
            }

            override fun onNext(t: Int) {
                Log.d(TAG,"接收到事件"+t.toString())
            }

            override fun onError(e: Throwable) {
                Log.d(TAG,"处理Error事件")
            }

        })*/
        Observable.create(object:ObservableOnSubscribe<Int>{
            override fun subscribe(emitter: ObservableEmitter<Int>) {
                emitter.onNext(1)
                emitter.onNext(2)
                emitter.onError(Throwable("抛出了一个错误"))
            }

        }).onErrorReturn(object:Function<Throwable,Int>{
            override fun apply(t: Throwable): Int {
                Log.d(TAG,"在onErrorReturn中处理错误"+t.toString())
                return 333
            }

        }).subscribe(object:Observer<Int>{
            override fun onComplete() {
                Log.d(TAG,"处理Complete事件")
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
                Log.d(TAG,"处理Error事件")
            }

            override fun onNext(t: Int) {
                Log.d(TAG,"接收到事件"+t.toString())
            }

        })

        /*====================================RxJava功能操作符end===============================================*/

    }


}
