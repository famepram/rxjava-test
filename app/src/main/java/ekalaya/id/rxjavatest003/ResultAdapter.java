package ekalaya.id.rxjavatest003;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Femmy on 9/13/2017.
 */

public class ResultAdapter extends ArrayAdapter<String> {

    private ArrayList<String> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
    }

    public ResultAdapter(Context context,  ArrayList<String> data) {
        super(context, 0, data);
        mContext = context;
        dataSet = data;
    }

    public void modifyData(ArrayList<String> dataSet){
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.simple_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.listitem);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.txtName.setText(item);
        return result;
    }
}
