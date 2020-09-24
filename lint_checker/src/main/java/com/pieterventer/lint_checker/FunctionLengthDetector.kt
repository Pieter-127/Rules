package com.pieterventer.lint_checker

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod

@Suppress("UnstableApiUsage")
class FunctionLengthDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes() = listOf(UMethod::class.java)

    override fun createUastHandler(context: JavaContext) =
        FunctionNameHandler(context)

    class FunctionNameHandler(private val context: JavaContext) :
        UElementHandler() {

        private val variableMinimumLength = 5

        override fun visitMethod(node: UMethod) {

            if (node.name.length < variableMinimumLength) {
                context.report(
                    issue = functionLengthIssue,
                    scope = node as UElement,
                    location = context.getNameLocation(node),
                    message = "this method can be better named"
                )
            }
        }

    }
}

