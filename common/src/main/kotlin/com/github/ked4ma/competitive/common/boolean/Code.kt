package com.github.ked4ma.competitive.common.boolean

// convert boolean value to "Yes"/"No"
//   true:  "Yes"
//   false: "No"
fun Boolean.toYesNo() = if (this) "Yes" else "No"
