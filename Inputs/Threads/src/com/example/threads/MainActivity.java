package com.example.threads;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText entrada;
	private TextView salida;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		entrada = (EditText) findViewById(R.id.entrada);
		salida = (TextView) findViewById(R.id.salida);

	}

	public void calcularOperacion(View view) {
		int n = Integer.parseInt(entrada.getText().toString());
		salida.append(n + "! = ");
		/*
		 * MyThread myThread = new MyThread(n); myThread.start();
		 */

		MyTask myTask = new MyTask();
		myTask.execute(n);
	}

	public int factorial(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res = res * i;
			SystemClock.sleep(1000);
		}
		return res;
	}

	class MyThread extends Thread {
		private int n, res;

		public MyThread(int n) {
			this.n = n;
		}

		@Override
		public void run() {
			res = factorial(n);
			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					salida.append(res + "\n");
				}
			});

		}

	}

	class MyTask extends AsyncTask<Integer, Integer, Integer> {
		private ProgressDialog progress;

		@Override
		protected void onPreExecute() {
			progress = new ProgressDialog(MainActivity.this);
			progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progress.setMessage("Loading...");
			//progress.setCancelable(false);
			progress.setCancelable(true);
			progress.setOnCancelListener(new OnCancelListener() {

				@Override
				public void onCancel(DialogInterface dialog) {
					// TODO Auto-generated method stub
					MyTask.this.cancel(true);
				}
			});
			progress.setMax(100);
			progress.setProgress(0);
			progress.show();

		}

		@Override
		protected Integer doInBackground(Integer... arg0) {
			// TODO Auto-generated method stub
			int res = 1;
			for (int i = 1; i <= arg0[0] && !isCancelled(); i++) {
				res = res * i;
				SystemClock.sleep(1000);
				publishProgress(i * 100 / arg0[0]);
			}
			return res;
		}

		@Override
		protected void onProgressUpdate(Integer... porc) {
			progress.setProgress(porc[0]);
		}

		@Override
		protected void onPostExecute(Integer res) {
			progress.dismiss();
			salida.append(res + "\n");
		}
		
		protected void onCancelled(){
			salida.append("cancelado\n");
		}

	}
}
