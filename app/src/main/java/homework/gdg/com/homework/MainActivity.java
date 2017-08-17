package homework.gdg.com.homework;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.OnUpdateListener,
        SwipeRefreshLayout.OnRefreshListener {

    private Adapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ((DefaultItemAnimator) recyclerView.getItemAnimator())
                .setSupportsChangeAnimations(false);

        mAdapter = new Adapter(getData(), this);
        recyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    private List<RowModel> getData() {
        List<RowModel> dataList = new ArrayList<>();
        dataList.add(new RowModel("Россия", "Москва"));
        dataList.add(new RowModel("Германия", "Берлин"));
        dataList.add(new RowModel("Грузия", "Тбилиси"));
        dataList.add(new RowModel("США", "Вашингтон"));
        dataList.add(new RowModel("Китай", "Пекин"));
        dataList.add(new RowModel("Катар", "Доха"));
        dataList.add(new RowModel("Чехия", "Прага"));
        dataList.add(new RowModel("Япония", "Токио"));
        dataList.add(new RowModel("Сингапур", "Сингапур"));
        dataList.add(new RowModel("Финляндия", "Хельсинки"));
        dataList.add(new RowModel("Индия", "Дели"));
        dataList.add(new RowModel("Австралия", "Мульбурн"));
        dataList.add(new RowModel("Швеция", "Стокгольм"));
        dataList.add(new RowModel("Армения", "Ереван"));
        dataList.add(new RowModel("Беларусь", "Минск"));
        dataList.add(new RowModel("Украина", "Киев"));
        dataList.add(new RowModel("Швеция", "Стокгольм"));
        dataList.add(new RowModel("Вьетнам", "Хошимин"));
        dataList.add(new RowModel("Англия", "Лондон"));
        dataList.add(new RowModel("Дания", "Копенгаген"));
        dataList.add(new RowModel("Вьетнам", "Хошимин"));
        dataList.add(new RowModel("Болгария", "София"));
        return dataList;
    }

    @Override
    public void updatePosition(int position) {
        mAdapter.notifyItemChanged(position);
    }

    @Override
    public void onRefresh() {
        List<RowModel> dataList = mAdapter.getDataList();
        for (RowModel rm : dataList) {
            rm.resetLikes();
        }
        mAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);

    }
}
