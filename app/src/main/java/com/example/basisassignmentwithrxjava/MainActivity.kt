package com.example.basisassignmentwithrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basisassignmentwithrxjava.Adapater.Adapter
import com.example.basisassignmentwithrxjava.Model.Data
import com.example.basisassignmentwithrxjava.Network.Retrofit
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter= Adapter(ArrayList<Data>())
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=adapter
        }

        val compositeDisposable= CompositeDisposable()
        compositeDisposable.add(getObservable().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ response->getObserver(response as ArrayList<Data>)},
                {t->onFailure(t)}
            ))
    }


    private fun getObservable(): Observable<List<Data>>
    {
        return Retrofit.api.getApiNetwork()
    }

    private fun getObserver(textList:ArrayList<Data>)
    {
        if(textList!= null && textList.size!=0)
        {
            adapter.setData(textList)
        }
    }

    private fun onFailure(t:Throwable)
    {
        Log.d("main", "onFailure: "+t.message)
    }

}
