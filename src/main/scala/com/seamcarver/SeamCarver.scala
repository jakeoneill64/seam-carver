package com.seamcarver

import edu.princeton.cs.algs4.Picture
import scala.math.{pow, sqrt}

class SeamCarver() {


  def energy(image: Picture, x: Int, y: Int): Double = {

    val sumDifferencesSquared = new (((Int, Int, Int), (Int, Int, Int)) => Double) {
      def apply(adjacent1 : Tuple3[Int, Int, Int], adjacent2: Tuple3[Int, Int, Int]): Double =

        pow(adjacent1._1 - adjacent2._1, 2) +
        pow(adjacent1._2 - adjacent2._2, 2) +
        pow(adjacent1._3 - adjacent2._3, 2)

    }

    if(x.equals(0) || y.equals(0) || x.equals(image.width() - 1) || y.equals(image.height() - 1))
      1000
    else{
      val left = image.getRGB(x - 1, y)
      val right = image.getRGB(x + 1, y)
      val up = image.getRGB(x, y - 1)
      val down = image.getRGB(x, y + 1)
      sqrt(

        sumDifferencesSquared(
          (left & 255, (left >> 8) & 255, (left >> 16) & 255),
          (right & 255, (right >> 8) & 255, (right >> 16) & 255)
        )

        +

        sumDifferencesSquared(
          (up & 255, (up >> 8) & 255, (up >> 16) & 255),
          (down & 255, (down >> 8) & 255, (down >> 16) & 255)
        )

      )

    }



  }

  //use dfs to get topological sort and find shortest path by inspecting in order
  def findHorizontalSeam(image: Picture): Array[Int] = {
    null
  }
  
  def findVerticalSeam(image: Picture): Array[Int] = {
    null
  }


  def transform(image: Picture, x: Int, y: Int): Picture = {
    null
  }

}

