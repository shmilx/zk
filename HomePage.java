package edu.ddxb.content;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidframe.R;
import com.lidroid.xutils.BitmapUtils;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import edu.ddxb.UrlUtil.CustomToast;
import edu.ddxb.UrlUtil.HttpMethod;
import edu.ddxb.UrlUtil.Link;
import edu.ddxb.UrlUtil.NetConnection;
import edu.ddxb.UrlUtil.UrlUtil;
import edu.ddxb.androidframe.bean.ChoicenessInfoDo;
import edu.ddxb.feameclass.BasePage;
import edu.ddxb.home.CourseVideoEntity;
import edu.ddxb.home.English_sort;
import edu.ddxb.home.RumenSeries;
import edu.ddxb.home.VedioPlay;
import edu.ddxb.home.advertisement.ADInfo;
import edu.ddxb.home.advertisement.CycleViewPager;
import edu.ddxb.home.advertisement.CycleViewPager.ImageCycleViewListener;
import edu.ddxb.home.advertisement.ViewFactory;
import edu.ddxb.home.advertisement.ad_cycleInfo;
import edu.ddxb.home.s.AmericaSchoolActivty;
import edu.ddxb.home.s.AplayLiuxueActivty;
import edu.ddxb.home.s.Jisu;
import edu.ddxb.home.s.Luntan;
import edu.ddxb.home.s.Mianqian;
import edu.ddxb.home.s.Shuangluqu;
import edu.ddxb.home.s.Zhuanxue;

public class HomePage extends BasePage implements OnClickListener {
	private LinearLayout fLl_rumen; // Ӣ������
	private LinearLayout fLl_liuxue; // ��ѧ��Ӣ��
	private LinearLayout fLl_shangwu;// ����Ӣ��
	private LinearLayout fLl_yuanxiao;// ����ԺУ
	private LinearLayout fLl_shuangluqu;// ˫¼ȡ��Ŀ
	private LinearLayout fLl_jisu;// ���޼�ͥ
	private LinearLayout fLl_shengliu;// ������ѧ
	private LinearLayout fLl_zhuanxue;// תѧ
	private LinearLayout fLl_luntan;// ��̳
	private LinearLayout fLl_mianqian;// ���ǩ֤
	private TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
	private List<ChoicenessInfoDo> choicenesslist;// ��Ƶ��ѡʵ�弯��
	String uri;// ������Ƶ�ĵ�ַ
	float price;// ��Ʒ�۸�
	String series_headline;
	String series_add;
	float series_discount;
	private int choicenessid;
	private int seriescourseid;
	String name;// ��Ʒ����
	String miaoshu;// ��Ʒ����
	int tag;// �ж��Ƿ��Ǵ��ҵ���Ʒ��������
	String TT;// �жϴ���ҳ�ĸ������������ģ����ţ���ѧ������
	public CycleViewPager cycleViewPager;
	private ImageView img1, img2, img3, img4, img5, img6;
	private List<CourseVideoEntity> Course_VideoInfoDo;
	BitmapUtils bitmapUtils;
	private Handler handler;
	View v;

	public HomePage(Context context) {
		super(context);
		// initData();
	}

	@Override
	public View initView(Context context) {
		v = View.inflate(context, R.layout.homepage, null);
		configImageLoader();
		cycleViewPager = (CycleViewPager) ((Activity) context)
				.getFragmentManager().findFragmentById(
						R.id.fragment_cycle_viewpager_content);
		// ��ʼ��ͼƬ
		setPic();
		// ��Ŀ���
		fLl_rumen = (LinearLayout) v.findViewById(R.id.ll_rumen);
		fLl_liuxue = (LinearLayout) v.findViewById(R.id.ll_liuxue);
		fLl_shangwu = (LinearLayout) v.findViewById(R.id.ll_shangwu);
		fLl_yuanxiao = (LinearLayout) v.findViewById(R.id.ll_yuanxiao);
		fLl_shuangluqu = (LinearLayout) v.findViewById(R.id.ll_shuangluqu);
		fLl_jisu = (LinearLayout) v.findViewById(R.id.ll_jisu);
		fLl_shengliu = (LinearLayout) v.findViewById(R.id.ll_shengliu);
		fLl_zhuanxue = (LinearLayout) v.findViewById(R.id.ll_zhuanxue);
		fLl_luntan = (LinearLayout) v.findViewById(R.id.ll_luntan);
		fLl_mianqian = (LinearLayout) v.findViewById(R.id.ll_mianqian);
		// ----------

		img1 = (ImageView) v.findViewById(R.id.chuguo_p1);
		img2 = (ImageView) v.findViewById(R.id.chuguo_p2);
		img3 = (ImageView) v.findViewById(R.id.touzi_p1);
		img4 = (ImageView) v.findViewById(R.id.touzi_p2);
		img5 = (ImageView) v.findViewById(R.id.youxing_p1);
		img6 = (ImageView) v.findViewById(R.id.youxing_p2);
		t1 = (TextView) v.findViewById(R.id.t1);
		t2 = (TextView) v.findViewById(R.id.t2);
		t3 = (TextView) v.findViewById(R.id.t3);
		t4 = (TextView) v.findViewById(R.id.t4);
		t5 = (TextView) v.findViewById(R.id.t5);
		t6 = (TextView) v.findViewById(R.id.t6);
		t7 = (TextView) v.findViewById(R.id.t7);
		t8 = (TextView) v.findViewById(R.id.t8);
		t9 = (TextView) v.findViewById(R.id.t9);
		t10 = (TextView) v.findViewById(R.id.t10);
		t11 = (TextView) v.findViewById(R.id.t11);
		t12 = (TextView) v.findViewById(R.id.t12);
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				if (msg.what == 88) {
					String json1 = (String) msg.obj;
					choicenesslist = new ArrayList<ChoicenessInfoDo>();
					ChoicenessInfoDo choicenessinfodo;
					try {
						JSONObject jsonObj = new JSONObject(json1);
						JSONArray jsonArr = jsonObj.getJSONArray("msg");
						for (int i = 0; i < jsonArr.length(); i++) {
							JSONObject jobj = jsonArr.getJSONObject(i);
							int series_id = jobj.getInt("series_id");
							String series_name = jobj.getString("series_name");
							String series_headline = jobj
									.getString("series_headline");
							String series_levle = jobj
									.getString("series_level");
							Float series_price = (float) jobj
									.getDouble("series_price");
							String series_pic_add = jobj
									.getString("series_pic_add");
							Float series_price_discount = (float) jobj
									.getDouble("series_price_discount");
							long time = jobj.getLong("series_publish_time");
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd-HH-mm-ss");
							Calendar calendar = Calendar.getInstance();
							calendar.setTimeInMillis(time);
							Date data = calendar.getTime();
							int series_sales = jobj.getInt("series_sales");
							int category_id = jobj.getInt("category_id");
							int combo_id = jobj.getInt("combo_id");
							choicenessinfodo = new ChoicenessInfoDo(series_id,
									series_name, series_headline, series_levle,
									series_price, series_pic_add,
									series_price_discount, data, series_sales,
									category_id, combo_id);
							choicenesslist.add(choicenessinfodo);
						}
						bitmapUtils = new BitmapUtils(v.getContext());
						bitmapUtils.configDiskCacheEnabled(true);
						bitmapUtils.configMemoryCacheEnabled(false);
						bitmapUtils.display(img1, Link.IMAGE_URL
								+ choicenesslist.get(0).getSeries_pic_add());
						t1.setText(choicenesslist.get(0).getSeries_name());
						t2.setText(choicenesslist.get(0).getSeries_price() + "");
						bitmapUtils.display(img2, Link.IMAGE_URL
								+ choicenesslist.get(1).getSeries_pic_add());
						t3.setText(choicenesslist.get(1).getSeries_name());
						t4.setText(choicenesslist.get(1).getSeries_price() + "");
						bitmapUtils.display(img3, Link.IMAGE_URL
								+ choicenesslist.get(2).getSeries_pic_add());
						t5.setText(choicenesslist.get(2).getSeries_name());
						t6.setText(choicenesslist.get(2).getSeries_price() + "");
						bitmapUtils.display(img4, Link.IMAGE_URL
								+ choicenesslist.get(3).getSeries_pic_add());
						t7.setText(choicenesslist.get(3).getSeries_name());
						t8.setText(choicenesslist.get(3).getSeries_price() + "");
						bitmapUtils.display(img5, Link.IMAGE_URL
								+ choicenesslist.get(4).getSeries_pic_add());
						t9.setText(choicenesslist.get(4).getSeries_name());
						t10.setText(choicenesslist.get(4).getSeries_price() + "");
						bitmapUtils.display(img6, Link.IMAGE_URL
								+ choicenesslist.get(5).getSeries_pic_add());
						t11.setText(choicenesslist.get(5).getSeries_name());
						t12.setText(choicenesslist.get(5).getSeries_price() + "");
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
		};
		// ����������������ģ���¼���Ӣ�����ţ���Сѧ��������ѧ��Ӣ�����Ӣ���������������������������
		fLl_rumen.setOnClickListener(this);
		fLl_liuxue.setOnClickListener(this);
		fLl_shangwu.setOnClickListener(this);
		fLl_yuanxiao.setOnClickListener(this);
		fLl_shengliu.setOnClickListener(this);
		fLl_shuangluqu.setOnClickListener(this);
		fLl_jisu.setOnClickListener(this);
		fLl_zhuanxue.setOnClickListener(this);
		fLl_luntan.setOnClickListener(this);
		fLl_mianqian.setOnClickListener(this);
		// ----------------------
		img1.setOnClickListener(this);
		img2.setOnClickListener(this);
		img3.setOnClickListener(this);
		img4.setOnClickListener(this);
		img5.setOnClickListener(this);
		img6.setOnClickListener(this);
		return v;
	}

	/**
	 * ����ImageLoder
	 */
	private void configImageLoader() {
		// ��ʼ��ImageLoader
		@SuppressWarnings("deprecation")
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.icon_stub) // ����ͼƬ�����ڼ���ʾ��ͼƬ
				.showImageForEmptyUri(R.drawable.icon_empty) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
				.showImageOnFail(R.drawable.icon_error) // ����ͼƬ���ػ��������з���������ʾ��ͼƬ
				.cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
				.cacheOnDisc(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
				// .displayer(new RoundedBitmapDisplayer(20)) // ���ó�Բ��ͼƬ
				.build(); // �������ù���DisplayImageOption����

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).defaultDisplayImageOptions(options)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO).build();
		ImageLoader.getInstance().init(config);
	}

	public void setPic() {
		String uri = Link.SERVER_URL + "/ad_cycle/ad_cycle.do";
		new NetConnection(uri, HttpMethod.POST,
				new NetConnection.SuccessCallback() {
					@Override
					public void onSuccess(String result) {
						System.out.println(result);
						List<ad_cycleInfo> lists = new ArrayList<ad_cycleInfo>();
						ad_cycleInfo ad;
						try {
							JSONObject jsonObj = new JSONObject(result);
							JSONArray jsonArr = jsonObj.getJSONArray("msg");
							for (int i = 0; i < jsonArr.length(); i++) {
								JSONObject jobj = jsonArr.getJSONObject(i);
								int id = jobj.getInt("ad_id");
								String pic = jobj.getString("ad_pic_add");
								ad = new ad_cycleInfo(id, pic);
								lists.add(ad);
							}

						} catch (JSONException e) {
							e.printStackTrace();
						}

						String[] imageUrls = new String[5];
						if(lists.size()!=0){
						for (int i = 0; i < lists.size(); i++) {
							imageUrls[i] = Link.IMAGE_URL
									+ lists.get(i).getPic();
						}
						
						for (int i = 0; i < imageUrls.length; i++) {
							System.out.println(imageUrls[i]);
						}
						}
						// initialize();

						List<ImageView> views = new ArrayList<ImageView>();
						List<ADInfo> infos = new ArrayList<ADInfo>();

						for (int i = 0; i < imageUrls.length; i++) {
							ADInfo info = new ADInfo();
							info.setUrl(imageUrls[i]);
							info.setContent("ͼƬ-->" + i);
							infos.add(info);
						}
						// �����һ��ImageView��ӽ���
						views.add(ViewFactory.getImageView(context,
								infos.get(infos.size() - 1).getUrl()));
						for (int i = 0; i < infos.size(); i++) {
							views.add(ViewFactory.getImageView(context, infos
									.get(i).getUrl()));
						}
						// ����һ��ImageView��ӽ���
						views.add(ViewFactory.getImageView(context, infos
								.get(0).getUrl()));

						// ����ѭ�����ڵ���setData����ǰ����
						System.out.println(cycleViewPager + "186");

						cycleViewPager.setCycle(true);

						// �ڼ�������ǰ�����Ƿ�ѭ��
						cycleViewPager.setData(views, infos,
								mAdCycleViewListener);
						// �����ֲ�
						cycleViewPager.setWheel(true);

						// �����ֲ�ʱ�䣬Ĭ��5000ms
						cycleViewPager.setTime(2000);
						// ����Բ��ָʾͼ���������ʾ��Ĭ�Ͽ���
						cycleViewPager.setIndicatorCenter();

					}
				}, new NetConnection.FailCallback() {

					@Override
					public void onFail(String result) {
						System.out.println("ʧ��");
					}
				});
	}

	private ImageCycleViewListener mAdCycleViewListener = new ImageCycleViewListener() {

		@Override
		public void onImageClick(ADInfo info, int position, View imageView) {
			if (cycleViewPager.isCycle()) {
				position = position - 1;
				Toast.makeText(context, "position-->" + info.getContent(),
						Toast.LENGTH_SHORT).show();
			}

		}

	};

	@Override
	public void initData() {
		String url = Link.SERVER_URL + "/course_video/find_homepage_series.do";
		UrlUtil.getHttpUrlConnection(url, handler, 88);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		// ��Ŀ���
		case R.id.ll_rumen:
			Intent intent1 = new Intent(getContext(), RumenSeries.class);
			intent1.putExtra("flag", 1);
			getContext().startActivity(intent1);
			break;
		case R.id.ll_liuxue:
			Intent intent2 = new Intent(getContext(), RumenSeries.class);
			intent2.putExtra("flag", 2);
			getContext().startActivity(intent2);
			break;
		case R.id.ll_shangwu:
			Intent intent3 = new Intent(getContext(), RumenSeries.class);
			intent3.putExtra("flag", 3);
			getContext().startActivity(intent3);
			break;
		case R.id.ll_yuanxiao:
			Intent intent4 = new Intent(getContext(),
					AmericaSchoolActivty.class);
			getContext().startActivity(intent4);
			break;
		case R.id.ll_shuangluqu:
			Intent intent5 = new Intent(getContext(), Shuangluqu.class);
			getContext().startActivity(intent5);
			break;
		case R.id.ll_jisu:
			Intent intent6 = new Intent(getContext(), Jisu.class);
			getContext().startActivity(intent6);
			break;
		case R.id.ll_shengliu:
			Intent intent7 = new Intent(getContext(), AplayLiuxueActivty.class);
			getContext().startActivity(intent7);
			break;
		case R.id.ll_zhuanxue:
			Intent intent8 = new Intent(getContext(), Zhuanxue.class);
			getContext().startActivity(intent8);
			break;
		case R.id.ll_luntan:
			Intent intent9 = new Intent(getContext(), Luntan.class);
			getContext().startActivity(intent9);
			break;
		case R.id.ll_mianqian:
			Intent intent10 = new Intent(getContext(), Mianqian.class);
			getContext().startActivity(intent10);
			break;
		case R.id.chuguo_p1:
			if (choicenesslist == null) {
				CustomToast.showToast(context, "�����쳣�����Ժ�����", 1000);
			} else {
				setposition(0);
			}
			break;
		case R.id.chuguo_p2:
			if (choicenesslist == null) {
				CustomToast.showToast(context, "�����쳣�����Ժ�����", 1000);
			} else {
				setposition(1);
			}
			break;
		case R.id.touzi_p1:
			if (choicenesslist == null) {
				CustomToast.showToast(context, "�����쳣�����Ժ�����", 1000);
			} else {
				setposition(2);
			}
			break;
		case R.id.touzi_p2:
			if (choicenesslist == null) {
				CustomToast.showToast(context, "�����쳣�����Ժ�����", 1000);
			} else {
				setposition(3);
			}
			break;
		case R.id.youxing_p1:
			if (choicenesslist == null) {
				CustomToast.showToast(context, "�����쳣�����Ժ�����", 1000);
			} else {
				setposition(4);
			}
			break;
		case R.id.youxing_p2:
			if (choicenesslist == null) {
				CustomToast.showToast(context, "�����쳣�����Ժ�����", 1000);
			} else {
				setposition(5);
			}
			break;
		}
	}

	public void setposition(int p) {
		Intent intent12 = new Intent(context, English_sort.class);
		seriescourseid = choicenesslist.get(p).getSeries_id();
		series_add = choicenesslist.get(p).getSeries_pic_add();
		price = choicenesslist.get(p).getSeries_price();
		name = choicenesslist.get(p).getSeries_name();
		choicenessid = choicenesslist.get(p).getSeries_id();
		series_headline = choicenesslist.get(p).getSeries_headline();
		miaoshu = choicenesslist.get(p).getSeries_levle();
		series_add = choicenesslist.get(p).getSeries_pic_add();
		series_discount = choicenesslist.get(p).getSeries_price_discount();
		intent12.putExtra("choicenessid", choicenessid);
		intent12.putExtra("series_headline", series_headline);
		intent12.putExtra("series_add", series_add);
		intent12.putExtra("series_discount", series_discount);
		intent12.putExtra("tag", 90);
		intent12.putExtra("series_add", series_add);
		intent12.putExtra("seriescourseid", seriescourseid);
		intent12.putExtra("name", name);
		intent12.putExtra("miaoshu", miaoshu);
		intent12.putExtra("price", price);
		getContext().startActivity(intent12);

	}
}
