package com.meltmedia.ramp.representation

import com.meltmedia.ramp.User

class UserRepresentation {
	String username

	static def fromUser(User user) {
		new UserRepresentation(username: user.username)
	}

	static def toUser(UserRepresentation user) {
		new User(username: user.username)
	}
}
