package com.github.tiste.nanoleafintellijplugin.services

import com.intellij.openapi.project.Project
import com.github.tiste.nanoleafintellijplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
