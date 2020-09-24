package com.pieterventer.lint_checker

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UVariable

@Suppress("UnstableApiUsage")
class VariableLengthDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes() = listOf(UVariable::class.java)

    override fun createUastHandler(context: JavaContext) =
        VariableLengthHandler(context)

    class VariableLengthHandler(private val context: JavaContext) :
        UElementHandler() {

        private val variableMinimumLength = 3

        override fun visitVariable(node: UVariable) {

            node.name?.let {
                if (it.length < variableMinimumLength) {
                    context.report(
                        issue = variableLengthIssue,
                        scope = node as UElement,
                        location = context.getNameLocation(node),
                        message = "this variable can be better named"
                    )
                }
            }
        }
    }
}
