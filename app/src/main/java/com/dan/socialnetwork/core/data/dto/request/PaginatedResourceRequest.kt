package com.dan.socialnetwork.core.data.dto.request

import com.dan.socialnetwork.util.Length

data class PaginatedResourceRequest(
    val pageNumber: Int = 0,
    val pageSize: Int = Length.PAGINATED_RESOURCE_PAGE,
)
