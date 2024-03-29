package frontend.app;

import java.io.IOException;

import frontend.nonfxml.SessionsView;
import frontend.nonfxml.view.IViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class SessionsController implements IViewController {
	public static final String MAIN_PAGE_RESOURCE = "/frontend/app/app.fxml";
	
	private TabPane tabPane;
	private AppController appController;
	
	public SessionsController(SessionsView view) {
		tabPane = view;
	}
	
	public void setAppController(AppController appController) {
		this.appController = appController;
	}

	private int numTabs() {
		return tabPane.getTabs().size();
	}
	private void selectLastTab() {
		selectTab(tabPane.getTabs().size() - 1);
	}
	private void selectTab(int index) {
		SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
		selectionModel.select(index);
	}
	public void addNewSession() throws IOException {
		Tab tab = new Tab("tab"+(numTabs()+1));
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				"/frontend/app/main-screen.fxml"
				));
		tab.setContent((SplitPane) loader.load());
		tabPane.getTabs().add(tab);
		selectLastTab();
	}
	
	
}
