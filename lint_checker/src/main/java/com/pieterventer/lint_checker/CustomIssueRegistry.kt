@file:Suppress("UnstableApiUsage")

package com.pieterventer.lint_checker

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

class CustomIssueRegistry : IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(
            stringLiteralIssue,
            integerLiteralIssue,
            variableLengthIssue,
            functionLengthIssue,
            outdatedVariableConventionIssue
        )

    override val api: Int
        get() = CURRENT_API
}

