import com.meltmedia.ramp.User;

class BootStrap {

    def init = { servletContext ->
		new User(username:'sukrit007').save()
		new User(username:'jamesbond').save()
    }
    def destroy = {
    }
}
