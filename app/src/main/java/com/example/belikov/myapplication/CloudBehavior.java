package com.example.belikov.myapplication;


import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

// Поведение изображения
public class CloudBehavior extends CoordinatorLayout.Behavior<ImageView> {

    private float initialX = 0;         // Начальное значение X изображения, от него и будем отталкиваться
    private boolean firstMove = true;   // Нам надо получить начальное значение X только один раз

    // Конструктор должен быть именно такой
    public CloudBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // Этот метод вызывается при изменении каждого элемента материального дизайна,
    // а мы будем отрабатывать, только если меняется AppBarLayout.
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    // Как только AppBarLayout изменился, сразу же меняется и наш элемент
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {

        // Инициализация начального значения X
        if (firstMove){
            firstMove = false;
            initialX = child.getX();
        }

        // Изображение будет ездить по низу экрана
        child.setX(initialX - dependency.getY()*1.5f );
        return false;
    }
}
