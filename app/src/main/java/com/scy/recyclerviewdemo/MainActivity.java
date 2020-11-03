package com.scy.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.scy.recyclerviewdemo.ExpandCollapse.ExpandCollapseActivity;
import com.scy.recyclerviewdemo.click.RcvClickActivity;
import com.scy.recyclerviewdemo.drag.DragActivity;
import com.scy.recyclerviewdemo.footer.FooterActivity;
import com.scy.recyclerviewdemo.gird.GirdActivity;
import com.scy.recyclerviewdemo.group.GroupActivity;
import com.scy.recyclerviewdemo.header.HeaderActivity;
import com.scy.recyclerviewdemo.horizontal.HorizontalActivity;
import com.scy.recyclerviewdemo.link.LinkActivity;
import com.scy.recyclerviewdemo.load.loadActivity;
import com.scy.recyclerviewdemo.refresh.refreshActivity;
import com.scy.recyclerviewdemo.slide.SlideActivity;
import com.scy.recyclerviewdemo.snaphelper.SnaphelperActivity;
import com.scy.recyclerviewdemo.sticky.StickyActivity;
import com.scy.recyclerviewdemo.swipe.SwipeActivity;
import com.scy.recyclerviewdemo.timeline.TimelineActivity;
import com.scy.recyclerviewdemo.vertical.VerticalActivity;
import com.scy.recyclerviewdemo.waterfall.WaterFallActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_click)
    Button mainClick;
    @BindView(R.id.main_drag)
    Button mainDrag;
    @BindView(R.id.main_expandcollapse)
    Button mainExpandcollapse;
    @BindView(R.id.main_footer)
    Button mainFooter;
    @BindView(R.id.main_grid)
    Button mainGrid;
    @BindView(R.id.main_group)
    Button mainGroup;
    @BindView(R.id.main_header)
    Button mainHeader;
    @BindView(R.id.main_horizontal)
    Button mainHorizontal;
    @BindView(R.id.main_link)
    Button mainLink;
    @BindView(R.id.main_load)
    Button mainLoad;
    @BindView(R.id.refresh_click)
    Button refreshClick;
    @BindView(R.id.main_slide)
    Button mainSlide;
    @BindView(R.id.main_snaphelper)
    Button mainSnaphelper;
    @BindView(R.id.main_sticky)
    Button mainSticky;
    @BindView(R.id.main_swip)
    Button mainSwip;
    @BindView(R.id.main_timeline)
    Button mainTimeline;
    @BindView(R.id.main_vertical)
    Button mainVertical;
    @BindView(R.id.main_waterfall)
    Button mainWaterfall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.main_click, R.id.main_drag, R.id.main_expandcollapse, R.id.main_footer, R.id.main_grid, R.id.main_group, R.id.main_header, R.id.main_horizontal, R.id.main_link, R.id.main_load, R.id.refresh_click, R.id.main_slide, R.id.main_snaphelper, R.id.main_sticky, R.id.main_swip, R.id.main_timeline, R.id.main_vertical, R.id.main_waterfall})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_click:
                startActivity(new Intent(MainActivity.this, RcvClickActivity.class));
                break;
            case R.id.main_drag:
                startActivity(new Intent(MainActivity.this, DragActivity.class));
                break;
            case R.id.main_expandcollapse:
                startActivity(new Intent(MainActivity.this, ExpandCollapseActivity.class));
                break;
            case R.id.main_footer:
                startActivity(new Intent(MainActivity.this, FooterActivity.class));
                break;
            case R.id.main_grid:
                startActivity(new Intent(MainActivity.this, GirdActivity.class));
                break;
            case R.id.main_group:
                startActivity(new Intent(MainActivity.this, GroupActivity.class));
                break;
            case R.id.main_header:
                startActivity(new Intent(MainActivity.this, HeaderActivity.class));
                break;
            case R.id.main_horizontal:
                startActivity(new Intent(MainActivity.this, HorizontalActivity.class));
                break;
            case R.id.main_link:
                startActivity(new Intent(MainActivity.this, LinkActivity.class));
                break;
            case R.id.main_load:
                startActivity(new Intent(MainActivity.this, loadActivity.class));
                break;
            case R.id.refresh_click:
                startActivity(new Intent(MainActivity.this, refreshActivity.class));
                break;
            case R.id.main_slide:
                startActivity(new Intent(MainActivity.this, SlideActivity.class));
                break;
            case R.id.main_snaphelper:
                startActivity(new Intent(MainActivity.this, SnaphelperActivity.class));
                break;
            case R.id.main_sticky:
                startActivity(new Intent(MainActivity.this, StickyActivity.class));
                break;
            case R.id.main_swip:
                startActivity(new Intent(MainActivity.this, SwipeActivity.class));
                break;
            case R.id.main_timeline:
                startActivity(new Intent(MainActivity.this, TimelineActivity.class));
                break;
            case R.id.main_vertical:
                startActivity(new Intent(MainActivity.this, VerticalActivity.class));
                break;
            case R.id.main_waterfall:
                startActivity(new Intent(MainActivity.this, WaterFallActivity.class));
                break;
        }
    }
}
