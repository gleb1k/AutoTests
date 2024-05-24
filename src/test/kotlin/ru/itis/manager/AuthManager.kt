package ru.itis.manager


import ru.itis.actions.Actions

class AuthManager {

    private var authorizedLogin: String? = null

    fun login(username: String, password: String) {
        if (authorizedLogin != username) {
            if (Actions.isLoggedIn()) {
                logout()
            }
            loginInternal(username, password)
        }
    }

    private fun loginInternal(username: String, password: String) {
        Actions.login(username, password)

        authorizedLogin = if (Actions.isLoggedIn()) {
            username
        } else {
            null
        }
    }

    fun logout() {
        Actions.logout()
        authorizedLogin = null
    }

    fun getCurrentUserLogin(): String? {
        return authorizedLogin
    }
}