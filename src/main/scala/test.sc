for {
          rank <- 1 until 9
          file <- 0 until 8
        } {
          val pos = rank.toString.concat(('a' + file).toChar.toString)
          println(pos)
        }

