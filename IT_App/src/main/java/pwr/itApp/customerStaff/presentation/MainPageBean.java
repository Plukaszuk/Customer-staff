package pwr.itApp.customerStaff.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pwr.itApp.customerStaff.domain.User;
import pwr.itApp.customerStaff.persistance.UserDAO;
import pwr.itApp.customerStaff.presentation.components.ElementsList;
import pwr.itApp.customerStaff.presentation.dto.RestaurantDTO;
import pwr.itApp.customerStaff.presentation.login.LoginForm;
import pwr.itApp.customerStaff.service.ActorActions;
import pwr.itApp.customerStaff.webapp.ApplicationURL;

@Component("mainPage")
@ViewScoped
public class MainPageBean implements ElementsList<RestaurantDTO> {
	
	@Autowired
	private LoginForm loginForm;
	
	@Autowired
	private ActorActions actorActions;
	
	@Autowired
	private UserDAO userDAO;
	
	public String loginAction() {
		if (actorActions.authenticate(loginForm.getLoginUsername(), 
				loginForm.getPassword())) {
			return ApplicationURL.MAIN_PAGE;
		} else {
			return ApplicationURL.MAIN_PAGE;
		}
	}
	
	public String getTest() {
		User usr = userDAO.find(1);
		
		return usr.getLogin();
	}

	@Override
	public List<RestaurantDTO> getValueList() {
		// TODO Auto-generated method stub
		List<RestaurantDTO> restaurants = new ArrayList<RestaurantDTO>();
		restaurants.add(new RestaurantDTO());
		return restaurants;
	}
}
