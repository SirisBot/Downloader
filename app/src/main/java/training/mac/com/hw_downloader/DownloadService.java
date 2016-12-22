package training.mac.com.hw_downloader;

import android.app.DownloadManager;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;

public class DownloadService extends Service {

    private DownloadManager dm;
    private String img = "https://cdn0.vox-cdn.com/thumbor/gCn4RokVUGmb96cmHekTOW7H_WM=/cdn0.vox-cdn.com/uploads/chorus_asset/file/7257911/OW_HalloweenLogin_TG_0038.0.jpg";
    private DownloadManager.Request req;

    public DownloadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        req = new DownloadManager.Request(
                Uri.parse(img));
        dm.enqueue(req);
    }

    @Override
    public void onDestroy() {

        req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        super.onDestroy();
    }
}
