import {createMuiTheme} from '@material-ui/core/styles'
import colors from './theme.json'

const theme = createMuiTheme({
  palette: colors.palette
})

export default theme;