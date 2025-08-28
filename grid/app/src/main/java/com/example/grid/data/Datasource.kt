package com.example.grid.data

import com.example.grid.R
import com.example.grid.model.PhotoGrid

class Datasource {
    fun loadTopics(): List<PhotoGrid> {
        return listOf(
            PhotoGrid(R.drawable.architecture, 58, R.string.architecture),
            PhotoGrid(R.drawable.automotive, 97, R.string.automotive),
            PhotoGrid(R.drawable.biology, 124, R.string.biology),
            PhotoGrid(R.drawable.business, 78, R.string.business),
            PhotoGrid(R.drawable.crafts, 121, R.string.crafts),
            PhotoGrid(R.drawable.culinary, 118, R.string.culinary),
            PhotoGrid(R.drawable.design, 423, R.string.design),
            PhotoGrid(R.drawable.drawing, 326, R.string.drawing),
            PhotoGrid(R.drawable.ecology, 230, R.string.ecology),
            PhotoGrid(R.drawable.engineering, 415, R.string.engineering),
            PhotoGrid(R.drawable.fashion, 92, R.string.fashion),
            PhotoGrid(R.drawable.film, 165, R.string.film),
            PhotoGrid(R.drawable.finance, 88, R.string.finance),
            PhotoGrid(R.drawable.gaming, 164, R.string.gaming),
            PhotoGrid(R.drawable.geology, 152, R.string.geology),
            PhotoGrid(R.drawable.history, 198, R.string.history),
            PhotoGrid(R.drawable.journalism, 67, R.string.journalism),
            PhotoGrid(R.drawable.law, 133, R.string.law),
            PhotoGrid(R.drawable.lifestyle, 305, R.string.lifestyle),
            PhotoGrid(R.drawable.music, 212, R.string.music),
            PhotoGrid(R.drawable.painting, 172, R.string.painting),
            PhotoGrid(R.drawable.photography, 321, R.string.photography),
            PhotoGrid(R.drawable.physics, 289, R.string.physics),
            PhotoGrid(R.drawable.tech, 118, R.string.tech)
        )
    }
}