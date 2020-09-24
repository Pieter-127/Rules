package com.pieterventer.lint_checker

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.ULiteralExpression

@Suppress("UnstableApiUsage")
class StringResourceDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes() = listOf(ULiteralExpression::class.java)
    override fun createUastHandler(context: JavaContext) =
        StringValueHandler(context)

    class StringValueHandler(private val context: JavaContext) :
        UElementHandler() {

        private val valueToDetect = "hello"
        override fun visitLiteralExpression(node: ULiteralExpression) {

            if (node.value.toString().equals(valueToDetect, true)) {
                context.report(
                    stringLiteralIssue,
                    node,
                    context.getNameLocation(node),
                    "this string value is sensitive and shouldn't be used, please refactor away"
                )
            }
        }
    }
}