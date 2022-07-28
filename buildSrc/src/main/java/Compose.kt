object Compose {
    const val compose_version = "1.2.0-rc03"
    const val composeCompilerVersion = "1.1.0-rc02"

    const val compose_ui = "androidx.compose.ui:ui:$compose_version"
    const val compose_material = "androidx.compose.material:material:$compose_version"
    const val compose_tooling_preview= "androidx.compose.ui:ui-tooling-preview:$compose_version"
    const val compose_lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"

    private const val activityComposeVersion = "1.3.1"
    const val compose_activity = "androidx.activity:activity-compose:${activityComposeVersion}"

    const val compose_ui_test = "androidx.compose.ui:ui-test-junit4:$compose_version"
    const val compose_ui_tooling= "androidx.compose.ui:ui-tooling:$compose_version"
    const val compose_ui_test_manifest = "androidx.compose.ui:ui-test-manifest:$compose_version"


    private const val navigationVersion = "2.4.0-beta02"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-beta01"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val lifecycleVersion = "2.4.0"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"

}