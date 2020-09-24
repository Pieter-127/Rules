package com.pieterventer.lint_checker

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.ULiteralExpression

@Suppress("UnstableApiUsage")
class IntegerResourceDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes() = listOf(ULiteralExpression::class.java)

    override fun createUastHandler(context: JavaContext) =
        ConstantValueHandler(context)

    class ConstantValueHandler(private val context: JavaContext) :
        UElementHandler() {

        private val valueToDetect = "7"

        override fun visitLiteralExpression(node: ULiteralExpression) {

            if (node.value.toString().equals(valueToDetect)) {
                context.report(
                    integerLiteralIssue,
                    node,
                    context.getNameLocation(node),
                    "this integer value is sensitive and shouldn't be used, please refactor away"
                )
            }
        }
    }
}
