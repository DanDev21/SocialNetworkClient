package com.dan.socialnetwork.util

object Time {
    const val SPLASH_SCREEN = 300L
    const val SPLASH_SCREEN_ANIMATION = 350
    const val BOTTOM_NAVIGATION_ITEM_LINE_ANIMATION = 250
}

object Length {

    const val PAGINATED_RESOURCE_PAGE = 20

    object Min {
        const val USERNAME = 3
        const val PASSWORD = 6

        const val IMAGE_FILE_SIZE = 125
    }

    object Max {
        const val COMMENT = 200
        const val USERNAME = 9
        const val DESCRIPTION_LINES = 5
    }
}

object SharedPrefKey {
    const val SHARED_PREFERENCES_MAIN_INSTANCE = "main_shared_preferences_instance"
    const val JWT = "jwt"
}

object Url {

    const val BASE = "http://192.168.100.3:8080/"
}

object RouteParams {
    const val ID = "id"
}

object QueryParams {
    const val RAW_DATA = "rawData"
}

object Routes {

    private const val DEFAULT = "/api"

    object User {

        private const val USER = "$DEFAULT/user"

        const val SIGN_UP = "$USER/sign_up"
        const val SIGN_IN = "$USER/sign_in"
        const val GET_PROFILE = "$USER/get_profile/{${RouteParams.ID}}"
        const val UPDATE = "$USER/update"
        const val UPDATE_PROFILE_PICTURE = "$USER/update_profile_image"
    }

    object Follow {

        private const val FOLLOW = "$DEFAULT/follow"

        const val FOLLOW_USER = "$FOLLOW/follow_user/{${RouteParams.ID}}"
        const val UNFOLLOW = "$FOLLOW/unfollow_user/{${RouteParams.ID}}"
    }

    object Post {

        private const val POST = "$DEFAULT/post"

        const val CREATE_POST = "$POST/create"
        const val DELETE_POST = "$POST/delete/{${RouteParams.ID}}"
        const val GET_FOLLOWED_USERS_POSTS = "$POST/get_followed_users_posts"
        const val GET_USER_POSTS = "$POST/get_user_posts"
    }

    object Like {

        private const val LIKE = "$DEFAULT/like"

        const val CREATE = "$LIKE/create"
        const val DELETE = "$LIKE/delete/{${RouteParams.ID}}"
    }

    object Comment {

        private const val COMMENT = "$DEFAULT/comment"

        const val CREATE = "$COMMENT/create"
        const val DELETE = "$COMMENT/delete/{${RouteParams.ID}}"
        const val GET_POST_COMMENTS = "$COMMENT/get_post_comments/{${RouteParams.ID}}"
    }

    object Activity {

        private const val ACTIVITY = "$DEFAULT/activity"

        const val GET_USER_ACTIVITIES = "$ACTIVITY/get_user_activities"
    }
}

object Test {

    object Tag {
        const val TEXT_FIELD_STANDARD = "txt_fld_std"
        const val TEXT_FIELD_PASSWORD = "txt_fld_pwd"
        const val BUTTON_TOGGLE_PASSWORD_VISIBILITY = "btn_toggle_pwd_visibility"
    }
}