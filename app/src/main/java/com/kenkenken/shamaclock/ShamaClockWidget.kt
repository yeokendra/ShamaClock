package com.kenkenken.shamaclock

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import java.util.*


/**
 * Implementation of App Widget functionality.
 */
class ShamaClockWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val hour: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.shama_clock_widget)

    if(hour >= 6 && hour <= 21) {
        views.setImageViewResource(R.id.iv_shaman, R.drawable.head_normal)
        views.setImageViewResource(R.id.iv_sun,R.drawable.sun)
    }else{
        views.setImageViewResource(R.id.iv_shaman, R.drawable.head_sleep)
        views.setImageViewResource(R.id.iv_sun,R.drawable.moon)
    }

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}