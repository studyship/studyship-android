package navigation

sealed class NavigationAction {
    data class Move(val className: String) : NavigationAction()
}