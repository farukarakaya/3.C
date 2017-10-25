package views;

/**
 * Created by ofk on 10/18/17.
 */
import model.Announcement;
import model.AnnouncementManager;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DataScrollerView  implements Serializable {
    private List<Announcement> announcements;
    private AnnouncementManager dataSource;

    @PostConstruct
    public void init() {
        dataSource = new AnnouncementManager();
        }

    public List<Announcement> getAnnouncements() {
        return dataSource.getAnnouncementsScroller();
    }

}
