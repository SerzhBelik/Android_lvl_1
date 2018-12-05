package com.example.belikov.myapplication;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



public class WeatherFragment extends ListFragment {

    boolean isExistCoatofarms;  // Можно ли расположить рядом фрагмент с гербом
    int currentPosition = 0;    // Текущая позиция (выбранный город)

    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    // activity создана, можно к ней обращаться. Выполним начальные действия
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

// Для того, чтобы показать список, надо задействовать адаптер.
// Такая конструкция работает для списков, например ListActivity.
// Здесь создаем из ресурсов список городов (из массива)
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Weather,
                android.R.layout.simple_list_item_activated_1);

        setListAdapter(adapter);


// Если это не повторное создание, то восстановим текущую позицию
        if (savedInstanceState != null) {
// Восстановление текущей позиции.
            currentPosition = savedInstanceState.getInt("WeatherParam", 0);
        }


    }

    // Сохраним текущую позицию (вызывается перед выходом из фрагмента)
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("WeatherParam", currentPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        currentPosition = position;
        showCoatOfArms();
    }

    private void showCoatOfArms() {
//        if (isExistCoatofarms) {
//// Выделим текущий элемент списка
            getListView().setItemChecked(currentPosition, true);
//
//// Проверим, что фрагмент с гербом существует в activity
//            WeatherParamFragment detail = (WeatherParamFragment)
//                    getFragmentManager().findFragmentById(R.id.w_param);
//// Если есть необходимость, то выведем герб
//            if (detail == null || detail.getIndex() != currentPosition) {
//// Создаем новый фрагмент с текущей позицией для вывода герба
//        WeatherParamFragment detail = new WeatherParamFragment();
//
//// Выполняем транзакцию по замене фрагмента
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.coat_of_arms, detail);  // замена фрагмента
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                ft.commit();
//            }
//
//        } else {
//// Если нельзя вывести герб рядом, откроем вторую activity
            Intent intent = new Intent();
            intent.setClass(getActivity(),WeatherParam.class);
//// и передадим туда параметры
            intent.putExtra("index", currentPosition);
            startActivity(intent);
//        }
//
//
    }
}