/*
 * Copyright (C) 2010-2012 Mike Novak <michael.novakjr@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.michaelnovakjr.numberpicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;

public class NumberPickerDialog extends AlertDialog implements OnClickListener {
    private OnNumberSetListener mListener;
    private NumberPicker mNumberPicker;

    private int mInitialValue;

    public NumberPickerDialog(Context context, int theme, int initialValue,
            CharSequence title, CharSequence positive, CharSequence negative) {
        super(context, theme);
        mInitialValue = initialValue;

        setTitle(title);
        setButton(BUTTON_POSITIVE, positive, this);
        setButton(BUTTON_NEGATIVE, negative, (OnClickListener) null);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_number_picker, null);
        setView(view);

        mNumberPicker = (NumberPicker) view.findViewById(R.id.num_picker);
        mNumberPicker.setCurrent(mInitialValue);
    }

    /**
     * Retrieve the number picker used in the dialog
     */
    public NumberPicker getNumberPicker() {
        return mNumberPicker;
    }

    /**
     * Set the range allowed for the number picker
     * @param start the minimum allowed value
     * @param end the maximum allowed value
     * @deprecated Instead this can be set by retrieving the numberpicker
     * and setting the value directly.
     */
    @Deprecated
    public void setRange(int start, int end) {
        mNumberPicker.setRange(start, end);
    }

    /**
     * Set the wrap option for the number picker
     * @param wrap true if values need to wrap
     * @deprecated Instead this can be set by retrieving the numberpicker
     * and setting the value directly.
     */
    @Deprecated
    public void setWrap(boolean wrap) {
        mNumberPicker.setWrap(wrap);
    }

    /**
     * Set the range for the number picker and the values to display
     * @param start the minimum allowed value
     * @param end the maximum allowed value
     * @param displayedValues values to display in the numberpicker instead of
     * the integer values of the range
     * @deprecated Instead this can be set by retrieving the numberpicker
     * and setting the value directly.
     */
    @Deprecated
    public void setRange(int start, int end, String[] displayedValues) {
        mNumberPicker.setRange(start, end, displayedValues);
    }

    public void setOnNumberSetListener(OnNumberSetListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (mListener != null) {
            mNumberPicker.clearFocus();
            mListener.onNumberSet(mNumberPicker.getCurrent());
        }
    }

    public interface OnNumberSetListener {
        public void onNumberSet(int selectedNumber);
    }
}
