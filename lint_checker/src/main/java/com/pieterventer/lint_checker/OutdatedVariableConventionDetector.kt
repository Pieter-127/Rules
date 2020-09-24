package com.pieterventer.lint_checker

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.JavaContext
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UVariable

@Suppress("UnstableApiUsage")
class OutdatedVariableConventionDetector : Detector(), Detector.UastScanner {

    override fun getApplicableUastTypes() = listOf(UVariable::class.java)

    override fun createUastHandler(context: JavaContext) =
        VariablePrefixHandler(context)

    class VariablePrefixHandler(private val context: JavaContext) :
        UElementHandler() {

        private val valueToDetect = "m"

        override fun visitVariable(node: UVariable) {

            node.name?.let {

                if (it.startsWith(valueToDetect, true) && it[1].isUpperCase()) {
                    context.report(
                        outdatedVariableConventionIssue,
                        node as UElement,
                        context.getNameLocation(node),
                        "this is an outdated naming convention, please stop using it"
                    )
                }
            }
        }
    }
}
